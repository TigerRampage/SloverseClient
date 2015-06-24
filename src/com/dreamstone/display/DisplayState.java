package com.dreamstone.display;

public enum DisplayState {
	SPLASH(0), MAIN_MENU(1);
	
	private int displayState;
	
	private DisplayState(int state) {
		displayState = state;
	}
	
	public int getDisplayState() {
		return displayState;
	}
}
