package com.dreamstone.display.listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SloverseWindowListener extends WindowAdapter {

	
	@Override
	public void windowOpened(WindowEvent we) {
		System.out.println("Omg I'm alive!");
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		System.out.println("Closing Sloverse...");
		
	}
}
