package com.dreamstone.logging;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SystemStream extends ByteArrayOutputStream {

	private Priority priority = Priority.INFO;
	
	/**
	 * @param p Priority messages are set at when logging for this particular instance.
	 */
	public SystemStream(Priority p) {
		this.priority = p;
	}
	
	public void flush() throws IOException {
		String record;
		synchronized (this) {
			super.flush();
			record = this.toString();
			super.reset();
			
			if (record.length() == 0 || record.equals(System.lineSeparator())) {
				return;
			}
			
			Log.logMessage(priority, record);
		}
	}
	
}
