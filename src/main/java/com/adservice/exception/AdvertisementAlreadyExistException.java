/**
 * 
 */
package com.adservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Sanjeet
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AdvertisementAlreadyExistException extends RuntimeException {
	
	@SuppressWarnings("unused")
	private static final long serialVErsionUID =1L;
	
	/**
	 * Create UserAlreadyExistException without Error message
	 */
	public AdvertisementAlreadyExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * UserAlreadyExistException with error messages
	 * @param message
	 */
	public AdvertisementAlreadyExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
