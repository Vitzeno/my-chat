package com.mindlinksoft.recruitment.mychat.exceptions;

@SuppressWarnings("serial")
public class ReaderException extends Exception {
	
	public ReaderException() {
		super();
	}
	
	public ReaderException(String errorMessage) {
		super(errorMessage);
	}
	
	public ReaderException(Throwable error) {
		super(error);
	}
	
	public ReaderException(String errorMessage, Throwable error) {
		super(errorMessage, error);
	}
}
