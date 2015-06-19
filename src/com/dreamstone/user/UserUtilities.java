package com.dreamstone.user;


public class UserUtilities {

	private static EnumOS currentOS = null;
	
	/**
	 * This can only be set once.
	 * @param os EnumOS corresponding to user's OS
	 */
	public static void setCurrentOS(EnumOS os) {
		if (currentOS == null) {
			currentOS = os;
		}
	}
	
	public static EnumOS getCurrentOS() {
		return currentOS;
	}
}
