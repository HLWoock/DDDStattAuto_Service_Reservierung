package de.woock.ddd.stattauto.reservierung.adapter.entities;

import lombok.Data;

@Data
public class VollerName {

	private Anrede anrede;
	private String vorname;
	private String name;
	private String  titel;

	public enum Titel {
		Kein(""), Ohne(""), Nichts(""), None(""), Nil(""), Love(""), 
		Dipl("Dipl.-Ing."), Dr("Dr."), Prof1("Prof. Dr.-Ing."), Prof2("Prof. Dr. phil. habil"), Prof3("ProfD rer. nat. habil.");
		
		public String titel;
		
		Titel(String titel) {
			this.titel = titel;
		}
	}
	
	public enum Anrede {
		Frau, Herr
	}
	
	public VollerName() {}
	
	public VollerName(Anrede anrede, Titel titel, String vorname, String name) {
		this.anrede  = anrede;
		this.titel   = titel.titel;
		this.vorname = vorname;
		this.name    = name;
	}
	
}

