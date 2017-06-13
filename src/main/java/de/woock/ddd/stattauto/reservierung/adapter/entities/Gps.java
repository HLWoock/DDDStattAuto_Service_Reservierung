package de.woock.ddd.stattauto.reservierung.adapter.entities;

import lombok.Data;

@Data
public class Gps {
	double lat;
	double lng;
	
	public Gps() {}
	
	public Gps(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}
}
