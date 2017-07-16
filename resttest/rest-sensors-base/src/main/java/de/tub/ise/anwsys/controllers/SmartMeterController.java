package de.tub.ise.anwsys.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.ise.anwsys.exceptions.SmartMeterListNotFoundException;
import de.tub.ise.anwsys.exceptions.SmartMeterNotFoundExceptions;
import de.tub.ise.anwsys.models.Measurements;
import de.tub.ise.anwsys.models.SmartMeter;
import de.tub.ise.anwsys.repos.MeasurementRepository;
import de.tub.ise.anwsys.repos.SmartMeterRepository;

@RestController
@RequestMapping(path = "/smartMeter")
public class SmartMeterController {

	@Autowired
	SmartMeterRepository SMrepository;
	
	@Autowired
	MeasurementRepository Mrepository;


	@RequestMapping(method = RequestMethod.GET)
	public List<SmartMeter> getAllSmartMeter() {
		validateSmartMeterList();
		List<SmartMeter> SmartMeters = SMrepository.findAll();
		return SmartMeters;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void addSmartmeter(@RequestBody SmartMeter input){
		SMrepository.save(new SmartMeter(input.getMeasurements()));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public SmartMeter getSmartMeter(@PathVariable String id) {
		validateSmartMeter(id);
		SmartMeter sm = SMrepository.findOne(id);
		return sm;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/spannung")
	public Double getSpannung(@PathVariable String id) {
		validateSmartMeter(id);
		return SMrepository.findOne(id).getAverageSpannung();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/stromstaerke")
	public double staerke(@PathVariable String id) {
		validateSmartMeter(id);
		return SMrepository.findOne(id).getAverageStaerke();
	}

	@RequestMapping(method = RequestMethod.PUT, value ="/{id}/measurement")
	public void addSpannung(@PathVariable String id,@RequestBody Measurements m){
		validateSmartMeter(id);
		Mrepository.save(new Measurements(m.getStromstaerke(),m.getStromspannung(),m.getSm(),m.getTime()));
	}
	

	public void validateSmartMeter(String id){
		if(this.SMrepository.findByName(id) == null){
			new SmartMeterNotFoundExceptions(id);
		}
	}

	public void validateSmartMeterList(){
		if(SMrepository.findAll() ==null){
			new SmartMeterListNotFoundException();
		}
	}
}
