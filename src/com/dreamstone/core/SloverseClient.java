package com.dreamstone.core;

import com.dreamstone.display.SloverseFrame;

public class SloverseClient {

	private SloverseFrame frame;
	private SloverseLoop gameLoop;
	
	public SloverseClient(int[] args) {
		initResources();
		
		
		frame = new SloverseFrame("Sloverse");
		
		
	}
	
	private void initResources() {
		
	}
	
	private void initConnection() {
		
	}
	
	public SloverseFrame getFrame() {
		return frame;
	}
	
	public SloverseLoop getGameLoop() {
		return gameLoop;
	}
}
