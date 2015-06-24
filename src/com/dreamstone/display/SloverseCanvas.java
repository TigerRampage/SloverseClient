package com.dreamstone.display;

import java.awt.Canvas;

public class SloverseCanvas extends Canvas {

	private static final long serialVersionUID = -5753687435845237812L;

	private DisplayState currentState;
	
	public SloverseCanvas() {
		this(DisplayState.SPLASH);
	}
	
	public SloverseCanvas(DisplayState initialState) {
		super();
		currentState = initialState;
		this.renderDisplayState(currentState);
	}
	
	public void renderDisplayState(DisplayState state) {
		switch (state) {
		case SPLASH: renderSplash();
		default: renderMainMenu();
		}
	}
	
	private void renderSplash() {
		
	}
	
	private void renderMainMenu() {
		
	}
	
}
