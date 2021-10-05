/**
 * 
 */
package com.adservice.exception;

/**
 * @author Sanjeet
 *
 */
public class AdvertisementNotFoundExceptionResponse {
	private String title;

	/**
	 * @param title
	 */
	public AdvertisementNotFoundExceptionResponse(String title) {
		super();
		this.title = title;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}