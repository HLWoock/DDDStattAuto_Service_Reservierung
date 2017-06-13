package de.woock.ddd.stattauto.reservierung.adapter;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.woock.ddd.stattauto.reservierung.entity.Reservierung;
import de.woock.ddd.stattauto.reservierung.repository.ReservierungsDao;
import de.woock.ddd.stattauto.reservierung.service.ReservierungsService;

@RestController
@RequestMapping("/Reservierungen")
public class ReservierungsAdapter {

	@Autowired
	ReservierungsDao reservierungsDao;
	
	@Autowired
	ReservierungsService reservierungsService;

	@PostMapping("/einrichten")
	Reservierung reservierungEinrichten(@RequestBody Reservierung reservierung) {
		return reservierungsDao.save(reservierung);
	}

	
	@GetMapping("/istMietobjektFrei/{von}/{bis}/{mietObjektId}")
	public Boolean istMietobjektFrei(@PathVariable("von") Long von, @PathVariable("bis") Long bis, 
			                  @PathVariable("mietObjektId") Long mietObjektId) {
		System.out.println(String.format("%s-%s %d", von, bis, mietObjektId));
		return reservierungsDao.reservierungsueberschneidungen(new Date(von), new Date(bis), mietObjektId) == 0;
	}
	
	@RequestMapping("/{id}")
	public Reservierung zeigeReservierungFuerId(@PathVariable Long id) {
		return reservierungsService.findOneByReservierungsId(id);
	}

	@RequestMapping("/mieter/{mieterId}")
	public List<Reservierung> zeigeReservierungFuerMieterMitId(@PathVariable Long mieterId) {
		return reservierungsService.findByMieter_MieterId(mieterId);
	}

	@RequestMapping("/mietobjekt/{mietObjektId}")
	public List<Reservierung> zeigeReservierungFuerMietObjektMitId(@PathVariable Long mietObjektId) {
		return reservierungsService.findByMietObjekt_MietObjektId(mietObjektId);
	}
}