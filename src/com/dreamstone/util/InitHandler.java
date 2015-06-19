package com.dreamstone.util;

import java.util.logging.Level;

import com.dreamstone.file.FileManager;
import com.dreamstone.file.SloverseLogger;

public final class InitHandler {

	/**
	 * Main init method for Sloverse.
	 * @param arguments
	 */
	public static void initSloverse(String[] arguments) {
		
		if (arguments.length > 0) {
			handleArguments(arguments);
		}
		
		initFilingSystem();
		initLogger();
		initResources();
	}
	
	/**
	 * Handles any arguments that come in through the command line.
	 * @param arguments
	 */
	private static void handleArguments(String[] arguments) {
		
	}
	
	/**
	 * Initializes the filing system and directories.
	 * CALL THIS BEFORE ANY OTHER INIT METHOD!
	 */
	private static void initFilingSystem() {
		FileManager.initalizeStoragePath();
	}
	
	/**
	 * Initializes the logger and its necessary files.
	 */
	private static void initLogger() {
		SloverseLogger.initLogger();
		SloverseLogger.logMessage(Level.FINE, "Logger successfully initialized!");
	}
	
	/**
	 * Loads in all images relating to Sloverse.
	 */
	private static void initResources() {
		
	}
	
}
