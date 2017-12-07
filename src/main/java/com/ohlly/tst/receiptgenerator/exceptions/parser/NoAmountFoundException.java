package com.ohlly.tst.receiptgenerator.exceptions.parser;

import com.ohlly.tst.receiptgenerator.exceptions.ReceiptGeneratorException;

public class NoAmountFoundException extends ReceiptGeneratorException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7339622358286734034L;

	public NoAmountFoundException() {
		super("No Amount Found");
	}

}
