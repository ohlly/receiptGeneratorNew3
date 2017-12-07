package com.ohlly.tst.receiptgenerator.exceptions.parser;

import com.ohlly.tst.receiptgenerator.exceptions.ReceiptGeneratorException;

public class ParserException extends ReceiptGeneratorException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3179200018391638329L;

	public ParserException(){
		super();
	}
	
	public ParserException(String msg){
		super(msg);
	}
}
