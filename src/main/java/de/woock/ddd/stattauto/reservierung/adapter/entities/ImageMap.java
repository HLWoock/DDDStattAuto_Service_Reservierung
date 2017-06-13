package de.woock.ddd.stattauto.reservierung.adapter.entities;

import javax.persistence.Lob;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageMap {

	@Lob
	private byte[] map;
	
	public ImageMap(byte[] map) {
		this.map = map;
	}
	
	public ImageMap() {}
}
