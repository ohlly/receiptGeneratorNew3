package com.ohlly.tst.receiptgenerator.exceptions.parser;

public class NoQuantityFoundException extends ParserException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7253479445472391578L;

	public NoQuantityFoundException(){
		super("No quantity found");
		
	}
}
