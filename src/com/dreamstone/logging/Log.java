package com.dreamstone.logging;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.dreamstone.file.FileManager;
import com.dreamstone.file.FileStructure;
import com.dreamstone.file.WritingHelper;

public class Log {

	private static StringBuilder logRecord = new StringBuilder();
	private static boolean logFileExists = false;
	private static String logFileName = null;
	
	private static PrintStream outStream = null;
	private static PrintStream errStream = null;
	
	public static void logMessage(Priority p, String message) {
		logMessage(p, message, true);
	}
	
	public static void logMessage(Priority p, String message, boolean logToFile) {
		String m = createMessage(p, message);
		if (p.getPriority() >= Priority.WARNING.getPriority() && errStream != null) {
			errStream.print(m);
		}
		else if (p.getPriority() < Priority.WARNING.getPriority() && outStream != null) {
			outStream.print(m);
		}
		logRecord.append(m);
		if (logToFile && p.getPriority() >= Priority.WARNING.getPriority()) {
			printToLogFile();
		}
	}
	
	public static String getLogRecord() {
		return logRecord.toString();
	}
	
	public static void setOutStream(PrintStream ps) {
		if (outStream == null) {
			outStream = ps;
		}
	}
	
	public static void setErrStream(PrintStream ps) {
		if (errStream == null) {
			errStream = ps;
		}
	}
	
	private static String createMessage(Priority p, String message) {
		StringBuilder m = new StringBuilder();
		
		if (!message.contains(System.lineSeparator())) {
			String line = p.toString() + ": " + message;
			m.append(line);
		}
		else {
			String[] lines = message.split(System.lineSeparator());
			for (int i = 0; i < lines.length; i++) {
				if (i == 0) {
					m.append(p.toString() + ": " + lines[i]);
				}
				else {
					if (lines[i].contains("\t")) {
						m.append(lines[i]);
					}
					else {
						m.append("\t" + lines[i]);
					}
				}
			}
		}
		
		m.append(System.lineSeparator());
		return m.toString();
	}
	
	private static void printToLogFile() {
		if (!logFileExists) {
			createNewLogFile();
		}
		WritingHelper.writeFile(FileStructure.getLogsDirectory(), logFileName, getLogRecord());
	}
	
	private static void createNewLogFile() {
		DateFormat dateFormat = new SimpleDateFormat("hh-mm-ss MM-dd-yyyy");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		
		String fileName = date + " log.txt";
		boolean success = FileManager.createNewFile(FileStructure.getLogsDirectory(), fileName);
		if (!success) {
			logMessage(Priority.ERROR, "Failed to create log file. It probably already has been created!", false);
		}
		logFileExists = success;
		logFileName = fileName;
	}
}
