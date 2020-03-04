package com.chainsys.musicapp.util;

import org.springframework.stereotype.Component;

@Component
public class DbException extends Exception{
	public DbException(String msg) {
		super(msg);
	}
}
