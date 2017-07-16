package de.tub.ise.anwsys.exceptions;

public class SmartMeterNotFoundExceptions extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SmartMeterNotFoundExceptions(String id){
		super("SmartMeter mit Id: "+id+" konnte nicht gefunden werden");
	}
}
