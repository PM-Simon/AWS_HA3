package de.tub.ise.anwsys.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.ise.anwsys.models.Measurements;
import de.tub.ise.anwsys.models.SmartMeter;
import de.tub.ise.anwsys.repos.MeasurementRepository;
import de.tub.ise.anwsys.repos.SmartMeterRepository;

@RestController
@RequestMapping(path = "/smartMeter")
public class SmartMeterController {

	@Autowired
	SmartMeterRepository repository;
	
	@Autowired
	MeasurementRepository rep;


	@RequestMapping(method = RequestMethod.GET)
	public List<SmartMeter> getAllSmartMeter() {
		List<SmartMeter> SmartMeters = repository.findAll();
		return SmartMeters;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void addSmartmeter(@RequestBody SmartMeter input){
		repository.save(new SmartMeter(input.getMeasurements()));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public SmartMeter getSmartMeter(@PathVariable String id) {
		SmartMeter sm = repository.findOne(id);
		return sm;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/spannung")
	public Double getSpannung(@PathVariable String id) {
		return repository.findOne(id).getAverageSpannung();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/stromstaerke")
	public double staerke(@PathVariable String id) {
		return repository.findOne(id).getAverageStaerke();
	}

	@RequestMapping(method = RequestMethod.PUT, value ="/{id}/measurement")
	public void addSpannung(@RequestBody Measurements m){
		rep.save(new Measurements(m.getStromstaerke(),m.getStromspannung(),m.getSm(),m.getTime()));
	}
	



}
