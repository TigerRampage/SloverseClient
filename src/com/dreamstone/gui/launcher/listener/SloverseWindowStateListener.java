package com.dreamstone.gui.launcher.listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

import com.dreamstone.core.SloverseClient;
import com.dreamstone.settings.FrameSettingsManager;

public class SloverseWindowStateListener implements WindowStateListener {

	@Override
	public void windowStateChanged(WindowEvent e) {
		
		if (e.getSource().equals(SloverseClient.getSloverse().getFrame())) {
			if ((e.getNewState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH
				&& (e.getOldState() & JFrame.MAXIMIZED_BOTH) != JFrame.MAXIMIZED_BOTH) {
				System.out.println("The launcher is maximized!");
				FrameSettingsManager.setMaximized(true);
			}
			else if ((e.getNewState() & JFrame.MAXIMIZED_BOTH) != JFrame.MAXIMIZED_BOTH
					&& (e.getOldState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH) {
				System.out.println("The launcher isn't maximized!");
				FrameSettingsManager.setMaximized(false);
			}
		}
	}
}
