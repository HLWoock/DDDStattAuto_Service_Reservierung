package de.woock.ddd.stattauto.reservierung.adapter.entities;

import lombok.Data;

@Data
public class Adresse {

	private String strasse;
	private String nr;
	private String ort;
	private String postleitzahl;
	private String email;
	
	public Adresse() {}
	
	public Adresse (String strasse, String nr, String ort, String postleitzahl, String email) {
		this.strasse      = strasse;
		this.nr           = nr;
		this.ort          = ort;
		this.postleitzahl = postleitzahl;
		this.email        = email;
	}
	
	public enum MailProvider {
		web, gmail, aol, tcom, gmx;
		
		public String provider() {
			return this.name() + ".de";
		}
	}
}
