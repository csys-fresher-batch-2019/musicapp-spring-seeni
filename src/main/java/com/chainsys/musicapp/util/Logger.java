package com.chainsys.musicapp.util;

public class Logger {

	public static Logger getInstanceOf() {
		Logger logger = new Logger();
		return logger;
	}

	/**
	 * Displays all the Information messages
	 * 
	 * @param message
	 */

	public void info(Object message) {
		System.out.println(message);
	}

	/**
	 * Displays all warning messages
	 * 
	 * @param message
	 */

	public void warn(Object message) {
		System.out.println(message);
	}

	/**
	 * Displays all the error messages
	 * 
	 * @param message
	 */

	public void error(Object message) {
		System.err.println(message);
	}
}
