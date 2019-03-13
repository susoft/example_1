package com.soo.temp;

public class BookIdMismatchException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
