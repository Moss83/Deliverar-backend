package com.example.adtpoapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class NoContentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7401768723332361562L;

	public NoContentException() {
		super();
	}
}
