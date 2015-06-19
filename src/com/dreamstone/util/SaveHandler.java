package com.dreamstone.util;

import com.dreamstone.settings.FrameSettingsManager;

public class SaveHandler {

	public static void saveGame() {
		savePlayerState();
		FrameSettingsManager.saveFrameSettings();
	}
	
	private static void savePlayerState() {
		//Saving player to file!
		//Saves everything about the player (position, room, color, etc.)
	}
}
