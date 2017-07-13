package de.tub.ise.anwsys.controllers;

import java.sql.Timestamp;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.ise.anwsys.models.SmartMeter;
import de.tub.ise.anwsys.repos.SmartMeterRepository;

@RestController
@RequestMapping(path = "/smartMeter")
public class SmartMeterController {

	@Autowired
	SmartMeterRepository repository;

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/spannung")
	public void addNewSpannung(String id, double value, Timestamp time) {
		SmartMeter sm = (SmartMeter) repository.findByName(id);
		sm.getSpannung().put(time, value);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/spannung")
	public void addNewStromstaerke(String id, double value, Timestamp time) {
		SmartMeter sm = (SmartMeter) repository.findByName(id);
		sm.getStaerke().put(time, value);
	}

	//@RequestMapping(method = RequestMethod.GET)
	//public Collection<SmartMeter> getAllSmartMeter() {

	//}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public String getSmartMeter(String id) {
		double avSpann = getAverageSpannung(((SmartMeter) repository.findByName(id)));
		double avSta = getAverageStromstaerke(((SmartMeter) repository.findByName(id)));
		return "SmartMeter: " + id + "\nDurchschnittliche Spannung: " + avSpann + "\nDurchschnittliche Stromstaerke: "
				+ avSta;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/spannung")
	public String spannung(String id) {
		double avSpann = getAverageSpannung(((SmartMeter) repository.findByName(id)));
		return "SmartMeter: " + id + "\nDurchschnittliche Spannung: " + avSpann;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/stromstaerke")
	public String staerke(String id) {
		double avSta = getAverageStromstaerke(((SmartMeter) repository.findByName(id)));
		return "SmartMeter: " + id + "\nDurchschnittliche Spannung: " + avSta;
	}

	private double getAverageSpannung(SmartMeter sm) {

		double sum = 0;
		int nr = sm.getSpannung().size();

		Double[] k = (Double[]) sm.getSpannung().values().toArray();

		for (int i = 0; i < k.length; i++) {
			sum += k[i];
		}

		return sum / 1;

	}

	private double getAverageStromstaerke(SmartMeter sm) {

		double sum = 0;
		int nr = sm.getStaerke().size();

		Double[] k = (Double[]) sm.getStaerke().values().toArray();

		for (int i = 0; i < k.length; i++) {
			sum += k[i];
		}

		return sum / 1;

	}

	/*
	 * GET gibt HashMap aus
	 */
}
