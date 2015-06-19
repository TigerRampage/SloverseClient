package com.dreamstone.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.dreamstone.logging.Log;
import com.dreamstone.logging.Priority;

public class WritingHelper {

	//Success or failure
	public static boolean writeFile(Directory d, String fileName, String contents) {
		File f = FileManager.retrieveFile(d, fileName);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			writer.write(contents);
			writer.close();
		}
		catch (IOException ioe) {
			Log.logMessage(Priority.ERROR, "Writing to file failed!");
			Log.logMessage(Priority.ERROR, "Failed file: " + d.getFilePath() + File.separator + fileName);
			ioe.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean appendToFile(Directory d, String fileName, String contents) {
		File f = FileManager.retrieveFile(d, fileName);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			writer.append(contents);
			writer.close();
		}
		catch (IOException ioe) {
			Log.logMessage(Priority.ERROR, "Appending to file failed!");
			Log.logMessage(Priority.ERROR, "Failed file: " + d.getFilePath() + File.separator + fileName);
			ioe.printStackTrace();
			return false;
		}
		return true;
	}
}
