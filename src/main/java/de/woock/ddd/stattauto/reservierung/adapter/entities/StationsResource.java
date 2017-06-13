package de.woock.ddd.stattauto.reservierung.adapter.entities;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StationsResource<Station> extends ResourceSupport {
	private Long             stationsId;
	private Auswahlkriterien auswahlkriterien;
	
	public String getStadt() {
		return auswahlkriterien.getStadt();
	}

	public String getStadtteil() {
		return auswahlkriterien.getStadtteil();
	}
	
	public String getStandort() {
		return auswahlkriterien.getStandort();
	}
	
	public String getKuerzel() {
		return auswahlkriterien.getKuerzel();
	}
}
