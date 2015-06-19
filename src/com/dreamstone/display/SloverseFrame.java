package com.dreamstone.display;

import javax.swing.JFrame;

import com.dreamstone.data.FrameOptionsManager;
import com.dreamstone.display.listener.SloverseWindowFocusedListener;
import com.dreamstone.display.listener.SloverseWindowListener;

public class SloverseFrame extends JFrame {
	
	private static final long serialVersionUID = -1449521889774196405L;

	public SloverseFrame(String title) {
		super(title);
		
		this.setMinimumSize(FrameOptionsManager.getMinimumDimension());
		this.setMaximumSize(FrameOptionsManager.getMaximumDimension());
		this.setPreferredSize(FrameOptionsManager.getPreferredDimension());
		this.setSize(FrameOptionsManager.getFrameDimension());
		this.addFrameListeners();
		
		this.pack();
		this.setLocation(FrameOptionsManager.getFramePosition());
		this.setVisible(true);
	}
	
	private void addFrameListeners() {
		this.addWindowListener(new SloverseWindowListener());
		this.addWindowFocusListener(new SloverseWindowFocusedListener());
	}
}
