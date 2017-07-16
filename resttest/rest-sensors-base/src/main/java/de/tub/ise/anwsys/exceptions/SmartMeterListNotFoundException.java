package de.tub.ise.anwsys.exceptions;

public class SmartMeterListNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SmartMeterListNotFoundException(){
		super("Die Liste mit den SmartMeters konnte nicht gefunden werden!");
	}
	
}
