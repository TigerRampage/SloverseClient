package com.dreamstone.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.dreamstone.logging.Log;
import com.dreamstone.logging.Priority;
import com.dreamstone.user.EnumOS;
import com.dreamstone.user.UserUtilities;

public final class FileManager {

	private static final String s = File.separator;
	
	/**
	 * Initializes the file system. Identifies and sets the current operating system, which is used to identify the location
	 * of where all Sloverse files will be stored. Once this is complete, it proceeds to initialize those directories.
	 */
	public static void initalizeStoragePath() {
		String operatingSystem = System.getProperty("os.name").toLowerCase();
		if (operatingSystem.contains("win")) {
			//Windows
			String appData = System.getenv("APPDATA");
			FileStructure.appDir = new Directory(appData);
			UserUtilities.setCurrentOS(EnumOS.WINDOWS);
		}
		else if (operatingSystem.contains("os x")) {
			//Mac
			String appSupport = System.getProperty("user.home") + s + "Library" + s + "Application Support";
			FileStructure.appDir = new Directory(appSupport);
			UserUtilities.setCurrentOS(EnumOS.OSX);
		}
		else {
			//Linux, etc.
			String home = System.getProperty("user.home");
			FileStructure.appDir = new Directory(home);
			if (operatingSystem.contains("lin")) {
				UserUtilities.setCurrentOS(EnumOS.LINUX);
			}
			else {
				Log.logMessage(Priority.INFO, "Operating system is not supported. Setting to \"other\". Sorry!");
				UserUtilities.setCurrentOS(EnumOS.OTHER);
			}
		}
		initDirectories();
	}
	
	/**
	 * Sets the location of all directories.
	 */
	private static void initDirectories() {
		(FileStructure.sloverseDir = FileStructure.appDir.down("Sloverse")).makeDirectories();
		(FileStructure.optionsDir = FileStructure.sloverseDir.down("options")).makeDirectory();
		(FileStructure.logsDir = FileStructure.sloverseDir.down("logs")).makeDirectory();
	}
	
	/**
	 * Retrieves a File instance of a specific file/folder in a specific Directory
	 * @param d The specific Directory instance that contains the file being retrieved.
	 * @param fileName The name of the file being retrieved.
	 * @return The File instance of the specified file
	 */
	public static File retrieveFile(Directory d, String fileName) {
		try {
			return d.getFileFromDir(fileName);
		} catch (FileNotFoundException e) {
			Log.logMessage(Priority.ERROR, "File: " + fileName + " not found after attempt to retrieve it!");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * WARNING: This is for ACTUAL files only. Directories should use Directory.mkdir()
	 * @return File was successfully created. False if it already exists or failed to be created.
	 */
	public static boolean createNewFile(Directory d, String fileName) {
		File f = new File(d.getFilePath() + File.separator + fileName);
		if (f.exists()) {
			return false;
		}
		
		try {
			f.createNewFile();
		} catch (IOException e) {
			Log.logMessage(Priority.ERROR, "File could not be created!");
			Log.logMessage(Priority.ERROR, "Failed to create: " + d.getFilePath() + File.separator + fileName);
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
