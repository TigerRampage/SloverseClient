package com.dreamstone.util;

import java.io.PrintStream;

import com.dreamstone.file.FileManager;
import com.dreamstone.file.ResourceLoader;
import com.dreamstone.logging.Log;
import com.dreamstone.logging.Priority;
import com.dreamstone.logging.SystemStream;
import com.dreamstone.settings.FrameSettingsManager;

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
		initSettings();
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
		Log.setOutStream(System.out);
		SystemStream sysOut = new SystemStream(Priority.INFO);
		System.setOut(new PrintStream(sysOut, true));
		
		Log.setErrStream(System.err);
		SystemStream sysErr = new SystemStream(Priority.ERROR);
		System.setErr(new PrintStream(sysErr, true));
		Log.logMessage(Priority.INFO, "Logger successfully initialized!");
	}
	
	/**
	 * Loads in all images relating to Sloverse.
	 */
	private static void initResources() {
		ResourceLoader.loadResources();
	}
	
	/**
	 * Loads all Settings saved from previous play periods.
	 */
	private static void initSettings() {
		FrameSettingsManager.loadFrameSettings();
	}
	
}
