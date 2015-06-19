package com.dreamstone.display.listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.dreamstone.core.SloverseClient;
import com.dreamstone.core.SloverseLoop;
import com.dreamstone.util.SaveHandler;

public class SloverseWindowListener extends WindowAdapter {

	
	@Override
	public void windowOpened(WindowEvent we) {
		System.out.println("Omg I'm alive!");
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		System.out.println("Closing Sloverse...");
		
		SloverseLoop loopHandle = SloverseClient.getSloverse().getGameLoop();
		if (loopHandle.isRunning()) {
			System.out.println("Saving game...");
			SaveHandler.saveGame();
			
			System.out.println("Shutting down the game loop!");
			loopHandle.stop();
		}
		System.exit(0);
	}
}
