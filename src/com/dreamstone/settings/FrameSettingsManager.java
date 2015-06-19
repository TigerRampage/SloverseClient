package com.dreamstone.settings;

import java.awt.Dimension;
import java.awt.Point;

import com.dreamstone.core.SloverseClient;
import com.dreamstone.display.DisplayInfo;
import com.dreamstone.display.SloverseFrame;
import com.dreamstone.file.FileManager;
import com.dreamstone.file.FileStructure;
import com.dreamstone.file.ReadingHelper;
import com.dreamstone.file.WritingHelper;

public final class FrameSettingsManager {

	private static Dimension minDimension = new Dimension(200, 200);
	private static Dimension maxDimension = DisplayInfo.getMaxWindowBounds();
	private static Dimension preferredDimension = new Dimension(720, 480);
	
	private static Dimension frameDimension;
	private static Point framePosition;
	
	private static boolean isMaximized;
	
	public static void saveFrameSettings() {
		SloverseFrame frameHandle = SloverseClient.getSloverse().getFrame();
		
		frameDimension = frameHandle.getSize();
		framePosition = frameHandle.getLocation();
		
		StringBuilder sb = new StringBuilder();
		sb.append("frameWidth=" + (int)frameDimension.getWidth() + System.lineSeparator());
		sb.append("frameHeight=" + (int)frameDimension.getHeight() + System.lineSeparator());
		sb.append("framePosX=" + (int)framePosition.getX() + System.lineSeparator());
		sb.append("framePosY=" + (int)framePosition.getY() + System.lineSeparator());
		sb.append("maximized=" + isMaximized);
		String text = sb.toString();
		
		if (!FileStructure.getOptionsDirectory().contains("settings.txt")) {
			FileManager.createNewFile(FileStructure.getOptionsDirectory(), "settings.txt");
		}
		WritingHelper.writeFile(FileStructure.getOptionsDirectory(), "settings.txt", text);
	}
	
	public static void loadFrameSettings() {
		
		if (FileStructure.getOptionsDirectory().contains("settings.txt")) {
			String contents = ReadingHelper.readFile(FileStructure.getOptionsDirectory(), "settings.txt");
			if (contents == null || contents.isEmpty()) {
				setDefaultFrameSettings();
			}
			else {
				
				isMaximized = Boolean.parseBoolean(ReadingHelper.getValueFromNode("maximized", contents));
				if (isMaximized) {
					setDefaultFrameSettings();
				}
				else {
					int frameWidth = Integer.parseInt(ReadingHelper.getValueFromNode("frameWidth", contents));
					int frameHeight = Integer.parseInt(ReadingHelper.getValueFromNode("frameHeight", contents));
					int framePosX = Integer.parseInt(ReadingHelper.getValueFromNode("framePosX", contents));
					int framePosY = Integer.parseInt(ReadingHelper.getValueFromNode("framePosY", contents));
					
					frameDimension = new Dimension(frameWidth, frameHeight);
					framePosition = new Point(framePosX, framePosY);
				}
			}
		}
		else {
			setDefaultFrameSettings();
		}
	}
	
	private static void setDefaultFrameSettings() {
		frameDimension = preferredDimension;
		framePosition = new Point((int)((DisplayInfo.getScreenSize().getWidth() - frameDimension.getWidth()) / 2), (int)((DisplayInfo.getScreenSize().getHeight() - frameDimension.getHeight()) / 2));
	}
	
	public static Dimension getFrameDimension() {
		return frameDimension;
	}
	
	public static Dimension getMinimumDimension() {
		return minDimension;
	}
	
	public static Dimension getMaximumDimension() {
		return maxDimension;
	}
	
	public static Dimension getPreferredDimension() {
		return preferredDimension;
	}
	
	public static Point getFramePosition() {
		return framePosition;
	}
	
	public static void setMaximized(boolean b) {
		isMaximized = b;
	}
	
	public static boolean isMaximized() {
		return isMaximized;
	}
}
