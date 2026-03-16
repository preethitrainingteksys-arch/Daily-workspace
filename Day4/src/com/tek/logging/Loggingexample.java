package com.tek.logging;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loggingexample {
	private static final Logger logger=Logger.getLogger(Loggingexample.class.getName());
	public static void main(String[] args) {
		logger.setLevel(Level.SEVERE);
		logger.info("Application started");
		logger.warning("Low memory warning");
		logger.severe("System failure");
	}
	

}
