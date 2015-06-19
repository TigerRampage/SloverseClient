package com.dreamstone.logging;

public enum Priority {

	INFO(0), WARNING(1), ERROR(2);
	
	private int priority;
	
	private Priority(int p) {
		priority = p;
	}
	
	public int getPriority() {
		return priority;
	}
}
