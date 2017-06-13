package de.woock.ddd.stattauto.reservierung.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Reservierung {
	
	@Id
	@GeneratedValue
	private Long       reservierungsId;
	private Mieter     mieter;
	private MietObjekt mietObjekt;
	private Zeitraum   zeitraum;
	
	public Reservierung() { }
	
	public Reservierung(Mieter mieter, MietObjekt mietObjekt, Zeitraum zeitraum) {
		this.mieter     = mieter;
		this.mietObjekt = mietObjekt;
		this.zeitraum   = zeitraum;
	}
}
