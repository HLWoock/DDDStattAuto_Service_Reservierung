package de.woock.ddd.stattauto.reservierung.entity;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class MietObjekt {
	
	private Long mietObjektId;

	public MietObjekt() { }
	
	public MietObjekt(Long mietObjektId) {
		this.mietObjektId = mietObjektId;
	}
}
