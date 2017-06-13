package de.woock.ddd.stattauto.reservierung.adapter.entities;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutoResource<Auto> extends ResourceSupport {
	private Long           AutoId;
	private String         kennung;
	private String         typ;
	private FahrzeugKlasse klasse;
	private String         details;
	private Gps            position;
}
