package com.dreamstone.util;

import com.dreamstone.data.FrameOptionsManager;
import com.dreamstone.file.FileManager;
import com.dreamstone.logging.Log;
import com.dreamstone.logging.Priority;

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
		initOptions();
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
		Log.logMessage(Priority.INFO, "Logger successfully initialized!");
	}
	
	/**
	 * Loads in all images relating to Sloverse.
	 */
	private static void initResources() {
		
	}
	
	/**
	 * Loads all options saved from previous play periods.
	 */
	private static void initOptions() {
		FrameOptionsManager.loadFrameOptions();
	}
	
}
