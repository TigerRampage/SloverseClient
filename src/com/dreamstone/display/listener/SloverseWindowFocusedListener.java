package com.dreamstone.display.listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SloverseWindowFocusedListener extends WindowAdapter {
	
	@Override
	public void windowGainedFocus(WindowEvent e) {
		System.out.println("Focused!");
	}
	
    @Override
	public void windowLostFocus(WindowEvent e) {
    	System.out.println("Unfocused.");
    }
}
