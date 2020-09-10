package com.wildadventure.trip.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ErrorAddCommentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorAddCommentException() {
		// TODO Auto-generated constructor stub
	}

	public ErrorAddCommentException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ErrorAddCommentException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ErrorAddCommentException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ErrorAddCommentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
