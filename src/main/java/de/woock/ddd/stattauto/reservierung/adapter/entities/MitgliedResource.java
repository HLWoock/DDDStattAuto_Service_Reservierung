package de.woock.ddd.stattauto.reservierung.adapter.entities;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MitgliedResource<Mitglied> extends ResourceSupport {
	private Long       mitgliedId;
	private VollerName vollerName;
	private String     mitgliedsId;
	private String     password;
	private Adresse    adresse;
	private String     geburtsdatum;
	private Telefon    telefon;
}
