package de.tub.ise.anwsys.models;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SmartMeter {

	@Id
	String id;

	LinkedHashMap<Timestamp, Double> spannung = new LinkedHashMap<>();
	LinkedHashMap<Timestamp, Double> staerke = new LinkedHashMap<>();
	
	
		
	protected SmartMeter() {
		//empty constructor required by JPA
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LinkedHashMap<Timestamp, Double> getSpannung() {
		return spannung;
	}
	public void setSpannung(LinkedHashMap<Timestamp, Double> spannung) {
		this.spannung = spannung;
	}
	public LinkedHashMap<Timestamp, Double> getStaerke() {
		return staerke;
	}
	public void setStaerke(LinkedHashMap<Timestamp, Double> staerke) {
		this.staerke = staerke;
	}
	
	
	

}


