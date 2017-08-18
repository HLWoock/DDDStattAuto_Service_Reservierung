package de.woock.ddd.stattauto.reservierung.helper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.woock.ddd.stattauto.reservierung.entity.Zeitraum;

public class ZeitraumGenerator {
	private static Random rand = new Random();
	
	public static List<Zeitraum> getZeiträume() {
		
		List<Zeitraum> zeiten = new ArrayList<>();
		
		int anzahlReservierungen = 5 + rand.nextInt(7);
		for (int i = 0; i < anzahlReservierungen; i++) {
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime von = now.plusDays(1 + rand.nextInt(30)).plusHours(rand.nextInt(24));
			LocalDateTime bis = von.plusDays(1 + rand.nextInt(30)).plusHours(rand.nextInt(24));

			String start = String.format("%s.%s.%s %d:%d", von.getDayOfMonth(), von.getMonthValue(), von.getYear(), von.getHour(), 0);
			String stop  = String.format("%s.%s.%s %d:%d", bis.getDayOfMonth(), bis.getMonthValue(), bis.getYear(), bis.getHour(), 0);
			Zeitraum leizeit = new Zeitraum(start, stop);
			zeiten.add(leizeit);
		}
		return zeiten;
	}
}
