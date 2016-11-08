/**
 * 
 */
package com.neu.msd.exception;

/**
 * @author Harsh
 *
 */
public class UserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 255880318090727976L;

	/**
	 * 
	 */
	public UserException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public UserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public UserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
