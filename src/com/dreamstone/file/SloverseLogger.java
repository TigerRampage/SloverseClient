package com.dreamstone.file;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Takes information and logs it to a file.
 * It can log error reports, play messages etc.
 */
public class SloverseLogger {

	private static Logger sloverseLogger = Logger.getLogger("Sloverse Logger");
	
	/**
	 * WARNING: File directory MUST be initialized before calling this method.
	 */
	public static void initLogger() {
		DateFormat dateFormat = new SimpleDateFormat("hh-mm-ss MM-dd-yyyy");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		
		String fileName = date + " log.txt";
		boolean success = FileManager.createNewFile(FileStructure.logsDir, fileName);
		if (!success) {
			sloverseLogger.log(Level.SEVERE, "Failed to create log file. It probably already has been created!");
			return;
		}
		
		File f = FileManager.retrieveFile(FileStructure.logsDir, fileName);
		FileHandler handler = null;
		try {
			System.out.println(f.getAbsolutePath());
			handler = new FileHandler(f.getAbsolutePath());
			
		} catch (SecurityException | IOException e) {
			sloverseLogger.log(Level.SEVERE, "Failed to create log file for this program instance.");
			sloverseLogger.log(Level.SEVERE, "Failed file: " + f.getAbsolutePath());
			e.printStackTrace();
			return;
		}
		sloverseLogger.addHandler(handler);
		SimpleFormatter formatter = new SimpleFormatter();
		handler.setFormatter(formatter);
	}
	
	public static void logMessage(Level l, String message) {
		sloverseLogger.log(l, message);
//		System.err.println("SLOVERSE LOGGER: " + message);
		//Send message to file system to be logged.
		
		
		//Send to Server Control Panel to be output
	}
	
	public static void logSuspiciousMessage(Level l, String message) {
		sloverseLogger.log(l, "Suspicious activity: " + message);
		System.err.println("SLOVERSE LOGGER: Suspicious activity: " + message);
		//Send message to file system to be logged.
		
		
		//Send to Server Control Panel to be output
	}
}