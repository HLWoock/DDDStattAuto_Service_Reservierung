package de.woock.ddd.stattauto.reservierung.adapter.entities;

import lombok.Data;

@Data
public class Spezifikation {
	private String     beschreibung;
	private Gps        position;
	private String     oepnv;
	
	public Spezifikation () { }

	public Spezifikation(String beschreibung, Gps position, String oepnv) {
		this.beschreibung = beschreibung;
		this.position     = position;
		this.oepnv        = oepnv;
	}
	

}
