package de.woock.ddd.stattauto.reservierung.entity;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Mieter {

	private Long mieterId;
	
	public Mieter() { }

	public Mieter(Long mieterId) {
		this.mieterId = mieterId;
	}
	
	
}
