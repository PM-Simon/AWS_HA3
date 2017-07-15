package de.tub.ise.anwsys.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SmartMeter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore()
	@Id
	String id;

	@OneToMany(mappedBy = "sm")
	List<Measurements> measurements = new ArrayList<>();

	public SmartMeter(List<Measurements> measurements) {
		this.measurements = measurements;
	}

	protected SmartMeter() {
		// empty constructor required by JPA
	}

	public List<Measurements> getMeasurements() {
		return measurements;
	}

	public void setMeasurements(List<Measurements> measurements) {
		this.measurements = measurements;
	}

	public double getAverageSpannung() {
		double i = 0;
		int cnt = 0;
		while (cnt < 15) {
			i += measurements.get(cnt).getStromspannung();
			cnt++;
		}

		return i / cnt;

	}

	public double getAverageStaerke() {
		double i = 0;
		int cnt = 0;
		while (cnt < 15) {
			i += measurements.get(cnt).getStromstaerke();
			cnt++;
		}

		return i / cnt;

	}

}
