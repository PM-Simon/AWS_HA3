package de.tub.ise.anwsys.models;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SmartMeter {

	@Id
	@Column (name =" SM_ID")
	String id;

	LinkedHashMap<Timestamp, Double> spannung = new LinkedHashMap<>();
	LinkedHashMap<Timestamp, Double> staerke = new LinkedHashMap<>();
	
	public SmartMeter(List spannung,List staerke){
		
	}
	
	protected SmartMeter() {
		//empty constructor required by JPA
	}
	public void addSpannung(Timestamp time, Double wert){
		spannung.put(time, wert);
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


