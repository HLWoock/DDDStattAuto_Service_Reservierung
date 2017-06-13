package de.woock.ddd.stattauto.reservierung.helper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import de.woock.ddd.stattauto.reservierung.entity.Zeitraum;
import de.woock.ddd.stattauto.reservierung.service.ReservierungsService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ErzeugeReservierungen {
	
	@Autowired
	ReservierungsService reservierungsService;
	
	@Test
	public void reserviereLokal(List<Zeitraum> zeitr�ume) {
		JdbcTestUtils.deleteFromTables(new JdbcTemplate(), "reservierung");
		Long     mieterId     = 125L; 
		Long     mietObjectId = 14L; 
		zeitr�ume.forEach(System.out::println);
		System.out.println(zeitr�ume);
//		reservierungsService.reserviere(new Reservierung(new Mieter(mieterId), new MietObjekt(mietObjectId), zeitraum));
	}
}
