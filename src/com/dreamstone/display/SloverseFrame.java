package com.dreamstone.display;

import javax.swing.JFrame;

import com.dreamstone.display.listener.SloverseWindowFocusedListener;
import com.dreamstone.display.listener.SloverseWindowListener;
import com.dreamstone.settings.FrameSettingsManager;

public class SloverseFrame extends JFrame {
	
	private static final long serialVersionUID = -1449521889774196405L;

	public SloverseFrame(String title) {
		super(title);
		
		this.setMinimumSize(FrameSettingsManager.getMinimumDimension());
		this.setMaximumSize(FrameSettingsManager.getMaximumDimension());
		this.setPreferredSize(FrameSettingsManager.getPreferredDimension());
		
		if (FrameSettingsManager.getFrameDimension().width >= this.getMaximumSize().width &&
			FrameSettingsManager.getFrameDimension().height >= this.getMaximumSize().height) {
			this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		}
		else if (FrameSettingsManager.getFrameDimension().width < this.getMaximumSize().width &&
				FrameSettingsManager.getFrameDimension().height < this.getMaximumSize().height) {
			this.setPreferredSize(FrameSettingsManager.getFrameDimension());
		}
		this.addFrameListeners();
		
		this.pack();
		this.setLocation(FrameSettingsManager.getFramePosition());
		this.setVisible(true);
	}
	
	private void addFrameListeners() {
		this.addWindowListener(new SloverseWindowListener());
		this.addWindowFocusListener(new SloverseWindowFocusedListener());
	}
}
