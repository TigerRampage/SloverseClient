package com.dreamstone.util;

import com.dreamstone.data.FrameOptionsManager;

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
	 * Initialized the filing system and directories.
	 */
	private static void initFilingSystem() {
		
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
