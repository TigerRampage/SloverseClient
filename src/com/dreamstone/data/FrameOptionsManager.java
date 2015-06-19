package com.dreamstone.data;

import java.awt.Dimension;
import java.awt.Point;

import com.dreamstone.core.SloverseClient;
import com.dreamstone.display.DisplayInfo;
import com.dreamstone.display.SloverseFrame;

public class FrameOptionsManager extends OptionsManager {

	private static Dimension minDimension = new Dimension(200, 200);
	private static Dimension maxDimension = DisplayInfo.getScreenSize();
	private static Dimension preferredDimension = new Dimension(720, 480);
	
	private static SloverseFrame frameHandle = SloverseClient.getSloverse().getFrame();
	private static Dimension frameDimension;
	private static Point framePosition;
	
	
	public static void saveFrameOptions() {
		
		frameDimension = frameHandle.getSize();
		framePosition = frameHandle.getLocation();
		//Save options to file.
	}
	
	public static void loadFrameOptions() {
		
		/*Check if settings file exists
		if (exists) {
			frameDimension = (get Dimension from file)
			framePosition = (get Position from file)
		}
		else {
			frameDimension = new Dimension();
			framePosition = new Point((int)((DisplayInfo.getScreenSize().getWidth() - frameDimension.getWidth()) / 2), (int)((DisplayInfo.getScreenSize().getHeight() - frameDimension.getHeight()) / 2));
		}
		*/
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
}
