package de.tub.ise.anwsys.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Measurements implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Measurement_ID")
	private long id;
	
	@JsonIgnore
	@ManyToOne
	SmartMeter sm;
	
	double Stromstaerke;
	double Stromspannung;
	Timestamp time;

	public Measurements(){
		
	}
	
	public Measurements(double ss, double sp,SmartMeter sm,Timestamp time){
		this.Stromspannung = sp;
		this.Stromstaerke = ss;
		this.sm =sm;
		this.time = time;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public SmartMeter getSm() {
		return sm;
	}

	public void setSm(SmartMeter sm) {
		this.sm = sm;
	}

	public double getStromstaerke() {
		return Stromstaerke;
	}

	public void setStromstaerke(double stromstaerke) {
		Stromstaerke = stromstaerke;
	}

	public double getStromspannung() {
		return Stromspannung;
	}

	public void setStromspannung(double stromspannung) {
		Stromspannung = stromspannung;
	}
	
	
	
}
