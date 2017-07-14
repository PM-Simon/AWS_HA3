package de.tub.ise.anwsys.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(method = RequestMethod.GET, path = "")
	public String test() {
		System.out.println("jap");
		return "YES";
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addSmartMeter(@RequestBody JSONObject obj) {

	}

	@RequestMapping(method = RequestMethod.GET)
	public String getAllSmartMeter() {
		String output = "";
		List<SmartMeter> list = repository.findAll();
		for (SmartMeter sm : list) {
			double avSpann = getAverageSpannung(((SmartMeter) repository.findByName(sm.getId())));
			double avSta = getAverageStromstaerke(((SmartMeter) repository.findByName(sm.getId())));
			String s = "SmartMeter: " + sm.getId() + "\nDurchschnittliche Spannung: " + avSpann
					+ "\nDurchschnittliche Stromstaerke: " + avSta;
			output += s + "/n";
		}
		return output;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public String getSmartMeter(@PathVariable String id) {
		double avSpann = getAverageSpannung(((SmartMeter) repository.findByName(id)));
		double avSta = getAverageStromstaerke(((SmartMeter) repository.findByName(id)));
		return "SmartMeter: " + id + "\nDurchschnittliche Spannung: " + avSpann + "\nDurchschnittliche Stromstaerke: "
				+ avSta;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/spannung")
	public String spannung(@PathVariable String id) {
		double avSpann = getAverageSpannung(((SmartMeter) repository.findByName(id)));
		return "SmartMeter: " + id + "\nDurchschnittliche Spannung: " + avSpann;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/stromstaerke")
	public String staerke(@PathVariable String id) {
		double avSta = getAverageStromstaerke(((SmartMeter) repository.findByName(id)));
		return "SmartMeter: " + id + "\nDurchschnittliche Spannung: " + avSta;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/spannung")
	public void addNewSpannung(@PathVariable String id) {
		SmartMeter sm = (SmartMeter) repository.findByName(id);
		// sm.getSpannung().put(time, value);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/spannung")
	public void addNewStromstaerke(String id, double value, Timestamp time) {
		SmartMeter sm = (SmartMeter) repository.findByName(id);
		sm.getStaerke().put(time, value);
	}

	private double getAverageSpannung(SmartMeter sm) {
		int x = 1311;
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
		int md = 232;
		int i = 1;
		int nr = sm.getStaerke().size();

		Double[] k = (Double[]) sm.getStaerke().values().toArray();

		for (int i = 0; i < k.length; i++) {
			sum += k[i];
		}

		return md / i;

	}

}
