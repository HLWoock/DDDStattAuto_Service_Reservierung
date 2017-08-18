package de.woock.ddd.stattauto.reservierung;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.converters.Auto;

import de.woock.ddd.stattauto.reservierung.adapter.entities.AutoResource;
import de.woock.ddd.stattauto.reservierung.adapter.entities.Mitglied;
import de.woock.ddd.stattauto.reservierung.adapter.entities.MitgliedResource;
import de.woock.ddd.stattauto.reservierung.adapter.entities.Station;
import de.woock.ddd.stattauto.reservierung.adapter.entities.StationsResource;
import de.woock.ddd.stattauto.reservierung.entity.MietObjekt;
import de.woock.ddd.stattauto.reservierung.entity.Mieter;
import de.woock.ddd.stattauto.reservierung.entity.Reservierung;
import de.woock.ddd.stattauto.reservierung.entity.Zeitraum;
import de.woock.ddd.stattauto.reservierung.helper.ZeitraumGenerator;
import de.woock.ddd.stattauto.reservierung.service.ReservierungsService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservierungTest {
	
	@Autowired ReservierungsService reservierungsService;

	@Autowired DiscoveryClient dc;
	@Autowired RestTemplate restTemplate;

	Random rand = new Random();
	
	@Test
	public void erstelleReservierungen() {
		List<ServiceInstance> mitgliederInstances = dc.getInstances("MITGLIEDER-SERVICE");
		ServiceInstance MitgliederServiceInstance = mitgliederInstances.get(0);
		String mitgliederUri = String.format("%s%s", MitgliederServiceInstance.getUri(), "/Mitglieder/erstes");
		
		List<ServiceInstance> fuhrparkInstances = dc.getInstances("FUHRPARK-SERVICE");
		ServiceInstance fuhrparkServiceInstance = fuhrparkInstances.get(0);
		String fuhrparkUri = String.format("%s%s", fuhrparkServiceInstance.getUri(), "/Stationen/");

		List<StationsResource<Station>> stationenResource = restTemplate.exchange(fuhrparkUri, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<StationsResource<Station>>>() {}).getBody();

		MitgliedResource<Mitglied> mitgliedResource = restTemplate.exchange(mitgliederUri, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<MitgliedResource<Mitglied>>() {}).getBody();
		
		while(mitgliedResource.getLink("nachfolgendes") != null) {
			mitgliedResource = holeNachfolgendesMitglied(mitgliedResource);
			List<Zeitraum> zeiträume = ZeitraumGenerator.getZeiträume();
			
			for (Zeitraum zeitraum2 : zeiträume) {
				int noStationen = stationenResource.size();
				StationsResource<Station> stationsResource = stationenResource.get(rand.nextInt(noStationen));
				
				String link = stationsResource.getLink("autos").getHref();
				List<AutoResource<Auto>> autosResource = restTemplate.exchange(link, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<AutoResource<Auto>>>() {}).getBody();
				
				int noAutos = autosResource.size();
				AutoResource<Auto> autoResource = autosResource.get(rand.nextInt(noAutos));
				reservierungsService.reserviere(new Reservierung(new Mieter(mitgliedResource.getMitgliedId()), 
						                                         new MietObjekt(autoResource.getAutoId()), 
						                                         zeitraum2));
			}
		}
	}

	private MitgliedResource<Mitglied> holeNachfolgendesMitglied(MitgliedResource<Mitglied> mitgliedResource) {
		String link = mitgliedResource.getLink("nachfolgendes").getHref();
		mitgliedResource = restTemplate.exchange(link, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<MitgliedResource<Mitglied>>() {}).getBody();
		return mitgliedResource;
	}
}
