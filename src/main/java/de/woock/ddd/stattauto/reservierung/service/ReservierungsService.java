package de.woock.ddd.stattauto.reservierung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.woock.ddd.stattauto.reservierung.entity.Reservierung;
import de.woock.ddd.stattauto.reservierung.repository.ReservierungsDao;

@Service
public class ReservierungsService {
	
	@Autowired
	private ReservierungsDao reservierungsDao;
	
	public Reservierung reserviere(Reservierung reservierung) {
		return reservierungsDao.save(reservierung);
	}

	public Reservierung findOneByReservierungsId(Long id) {
		return reservierungsDao.findOneByReservierungsId(id);
	}

	public List<Reservierung> findByMieter_MieterId(Long mieterId) {
		return reservierungsDao.findByMieter_MieterId(mieterId);
	}

	public List<Reservierung> findByMietObjekt_MietObjektId(Long mietObjektId) {
		return reservierungsDao.findByMietObjekt_MietObjektId(mietObjektId);
	}
}
