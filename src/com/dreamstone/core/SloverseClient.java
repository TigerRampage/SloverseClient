package com.dreamstone.core;

import java.awt.EventQueue;

import com.dreamstone.display.SloverseFrame;
import com.dreamstone.util.InitHandler;

public class SloverseClient {

	private static SloverseClient sloverseInstance;
	private SloverseFrame frame;
	private SloverseLoop gameLoop;
	
	public SloverseClient(String[] args) {
		InitHandler.initSloverse(args);
		frame = new SloverseFrame("Sloverse");
		gameLoop = new SloverseLoop();
		gameLoop.start();
	}
	
//	private void initConnection() {
//		
//	}
	
	public SloverseFrame getFrame() {
		return frame;
	}
	
	public SloverseLoop getGameLoop() {
		return gameLoop;
	}
	
	public static SloverseClient getSloverse() {
		return sloverseInstance;
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				sloverseInstance = new SloverseClient(args);
			}
		});
	}
}
