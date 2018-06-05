package org.fx.exception;

/**
 * This is a simple custom exception class
 * TODO: glorify further to print the actual error message makes it easier for debugging.
 * @author 617150
 *
 */
public class CurrencyException extends Exception{

	private static final long serialVersionUID = 3541365904992754901L;

	public CurrencyException(String message){
		super(message);
	}
	
	public CurrencyException(){
		super();
	}
	
}
