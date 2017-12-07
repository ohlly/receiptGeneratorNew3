package com.ohlly.tst.receiptgenerator.exceptions.handlers;

public class ReceiptGeneratorStandardExceptionHandler implements ReceiptGeneratorExceptionHandler{

	
	public void handleException(Exception e)
	{
	   System.out.println("Attention!: An Exception occurred: " + e.getMessage());
	}
	
}
