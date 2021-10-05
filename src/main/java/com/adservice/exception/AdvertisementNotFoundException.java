/**
 * 
 */
package com.adservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author USER
 *
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AdvertisementNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public AdvertisementNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param message
	 * This class Displays message of exception
	 */
	
	public AdvertisementNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}	
}