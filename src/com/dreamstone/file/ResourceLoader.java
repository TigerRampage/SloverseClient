package com.dreamstone.file;

import java.awt.image.BufferedImage;

import com.dreamstone.logging.Log;
import com.dreamstone.logging.Priority;

public class ResourceLoader {
	public static BufferedImage EXIT_BUTTON_HOVER;
	public static BufferedImage EXIT_BUTTON;
	public static BufferedImage LOGIN_BUTTON_HOVER;
	public static BufferedImage LOGIN_BUTTON;
	public static BufferedImage PLAY_BUTTON_HOVER;
	public static BufferedImage PLAY_BUTTON;
	public static BufferedImage SIGNUP_BUTTON_HOVER;
	public static BufferedImage SIGNUP_BUTTON;
	public static BufferedImage SLOVERSE_LOGO;
	
	public static void loadResources() {
		loadImages();
		//loadAudio, etc.
		Log.logMessage(Priority.INFO, "All resources have been successfully loaded!");
	}
	
	private static void loadImages() {
		String rootPath = "resources/images/";
		EXIT_BUTTON_HOVER = ReadingHelper.getImageFromResourceFile(rootPath + "exit_button_hover.png");
		EXIT_BUTTON = ReadingHelper.getImageFromResourceFile(rootPath + "exit_button.png");
		LOGIN_BUTTON_HOVER = ReadingHelper.getImageFromResourceFile(rootPath + "login_button_hover.png");
		LOGIN_BUTTON = ReadingHelper.getImageFromResourceFile(rootPath + "login_button.png");
		PLAY_BUTTON_HOVER = ReadingHelper.getImageFromResourceFile(rootPath + "play_button_hover.png");
		PLAY_BUTTON = ReadingHelper.getImageFromResourceFile(rootPath + "play_button.png");
		SIGNUP_BUTTON_HOVER = ReadingHelper.getImageFromResourceFile(rootPath + "signup_button_hover.png");
		SIGNUP_BUTTON = ReadingHelper.getImageFromResourceFile(rootPath + "signup_button.png");
		SLOVERSE_LOGO = ReadingHelper.getImageFromResourceFile(rootPath + "sloverse_logo.png");
	}
}
