package com.chainsys.otherclass;

public class Logger {
	
	public static Logger getInstanceOf() {
		Logger logger =new Logger();
		return logger;
	}
	public void info(Object message) {
		System.out.println(message);
	}
	public void warn(Object message) {
		System.out.println(message);
	}
	public void error(Object message) {
		System.err.println(message);
	}
}
