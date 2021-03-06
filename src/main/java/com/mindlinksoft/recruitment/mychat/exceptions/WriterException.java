package com.mindlinksoft.recruitment.mychat.exceptions;

/**
 * Custom exception for writer
 * 
 * @author Mohamed Yusuf
 */
@SuppressWarnings("serial")
public class WriterException extends Exception {
	
	public WriterException() {
		super();
	}
	
	public WriterException(String errorMessage) {
		super(errorMessage);
	}
	
	public WriterException(Throwable error) {
		super(error);
	}
	
	public WriterException(String errorMessage, Throwable error) {
		super(errorMessage, error);
	}

}
