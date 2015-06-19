package com.dreamstone.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.dreamstone.logging.Log;
import com.dreamstone.logging.Priority;

public class Directory {

	private String filePath = null;
	
	/**
	 * Creates a new Directory instance with the specified String path
	 * @param path The absolute path of the file that the directory refers to. The file MUST be a folder.
	 */
	public Directory(String path) {
		filePath = path;
		if (path == null || path.isEmpty()) {
			Log.logMessage(Priority.WARNING, "A new directory was instantiated with a null path! Something's not right!");
		}
	}
	
	/**
	 * Returns a File instance of this directory so File API operations may be performed. 
	 * @return A File instance referring to the absolute path of this Directory.
	 */
	public File toFile() {
		return new File(filePath);
	}
	
	/**
	 * Returns the parent Directory.
	 * @return A Directory instance of the parent folder.
	 */
	public Directory up() {
		File f = this.toFile();
		if (f.getParent() != null) {
			return new Directory(f.getParent());
		}
		else {
			Log.logMessage(Priority.WARNING, "A parent directory could not be returned for the following Directory!");
			Log.logMessage(Priority.WARNING, "Directory: \"" + this.getFilePath() + "\"");
			return null;
		}
	}
	
	/**
	 * Returns the specified child Directory.
	 * @param folderName The name of the folder within this Directory
	 * @return A Directory instance referring to path of the specified folder, or null if this does not exist.
	 */
	public Directory down(String folderName) {
		if (this.contains(folderName)) {
			return new Directory(this.filePath + File.separator + folderName);
		}
		else {
			Log.logMessage(Priority.WARNING, "A child directory could not be returned for the following path!");
			Log.logMessage(Priority.WARNING, "Directory: \"" + this.getFilePath() + File.separator + folderName + "\"");
			return null;
		}
	}
	
	/**
	 * Retrieves the names of all of the files within this directory.
	 * NOTE: This ONLY retrieves FILE names, not directories.
	 * @return an ArrayList of String objects the contain the names of the files within this directory.
	 */
	public ArrayList<String> getFileNames() {
		File[] allFiles = this.toFile().listFiles();
		ArrayList<String> onlyFiles = new ArrayList<String>();
		for (File f : allFiles) {
			if (f.isFile()) {
				onlyFiles.add(f.getName());
			}
		}
		return onlyFiles;
	}
	
	/**
	 * Retrieves Directory instances of all child folders.
	 * @return an ArrayList of Directory objects that refer to all child folders of this directory.
	 */
	public ArrayList<Directory> getSubDirectories() {
		File[] allFiles = this.toFile().listFiles();
		ArrayList<Directory> directories = new ArrayList<Directory>();
		for (File f : allFiles) {
			if (f.isDirectory()) {
				directories.add(new Directory(f.getAbsolutePath()));
			}
		}
		return directories;
	}
	
	/**
	 * Retrieves a specific File from this directory.
	 * @param fileName The name and extension of the file being retrieved from this directory.
	 * @return a File instance referring to the specified file name.
	 * @throws FileNotFoundException If the file that is being retrieved cannot be found within this directory, this exception will be thrown.
	 */
	public File getFileFromDir(String fileName) throws FileNotFoundException {
		File f = new File(this.getFilePath() + File.separator + fileName);
		if (!f.exists()) {
			Log.logMessage(Priority.ERROR, "The file you are trying to write to does not exist!");
			Log.logMessage(Priority.ERROR, "File: " + this.getFilePath() + File.separator + fileName);
			throw new FileNotFoundException("File " + this.getFilePath() + File.separator + fileName + " could not be found");
		}
		return f;
	}
	
	/**
	 * Detects whether or not a specific file or folder is located in this directory.
	 * @param fileOrDirName The name of the file or directory being searched for.
	 * @return A boolean value that corresponds to whether or not the file or folder is contained within this directory.
	 */
	public boolean contains(String fileOrDirName) {
		File f = new File(this.getFilePath() + File.separator + fileOrDirName);
		return f.exists();
	}
	
	/**
	 * Detects whether or not a specific file or folder is located in this directory.
	 * @param f The File instance of the file or folder being searched for.
	 * @return A boolean value that corresponds to whether or not the file or folder is contained within this directory.
	 */
	public boolean contains(File f) {
		return this.contains(f.getName());
	}
	
	/**
	 * Detects whether or not a specific folder is contained within this directory.
	 * @param d The Directory instance of the directory being searched for.
	 * @return A boolean value that corresponds to whether or not the folder is contained within this directory.
	 */
	public boolean contains(Directory d) {
		return this.contains(d.toFile());
	}
	
	/**
	 * Tests whether or not this directory actually exists.
	 * @return A boolean value corresponding to the existence of this directory.
	 */
	public boolean exists() {
		return this.toFile().exists();
	}
	
	/**
	 * Attempts to create this directory and any necessary parent directories.
	 * @return true ONLY if the directory and other necessary parent directories were created; false otherwise.
	 */
	public boolean makeDirectories() {
		boolean mkdirs = false;
		try {
			mkdirs = this.toFile().mkdirs();
		}
		catch (SecurityException se) {
			Log.logMessage(Priority.ERROR, "Denied access to directory: " + this.getFilePath());
			se.printStackTrace();
		}
		return mkdirs;
	}
	
	/**
	 * Attempts to create this directory.
	 * @return true ONLY if this directory was successfully created; false otherwise.
	 */
	public boolean makeDirectory() {
		boolean mkdir = false;
		try {
			mkdir = this.toFile().mkdir();
		}
		catch (SecurityException se) {
			Log.logMessage(Priority.ERROR, "Denied access to directory: " + this.getFilePath());
			se.printStackTrace();
		}
		return mkdir;
	}
	
	/**
	 * Retrieves the String corresponding to the path of this directory.
	 * @return a String value containing the absolute file path of this directory.
	 */
	public String getFilePath() {
		return filePath;
	}
}
