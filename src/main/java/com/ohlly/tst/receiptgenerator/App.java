package com.ohlly.tst.receiptgenerator;

import java.util.ArrayList;
import java.util.List;

import com.ohlly.tst.receiptgenerator.exceptions.handlers.ReceiptGeneratorStandardExceptionHandler;
import com.ohlly.tst.receiptgenerator.iomanager.InputManager;
import com.ohlly.tst.receiptgenerator.iomanager.InputManagerImpl;
import com.ohlly.tst.receiptgenerator.iomanager.OutputManager;
import com.ohlly.tst.receiptgenerator.iomanager.OutputManagerImpl;
import com.ohlly.tst.receiptgenerator.model.ProductTaxInfoItem;

/**
 * Hello world!
 *
 */
public class App 
{
	private ReceiptGeneratorStandardExceptionHandler ReceiptGeneratorStandardExceptionHandler;
    
    
    public List<String> printReceipt(List<String> inputItems){
    	
    	List<String> result = new ArrayList<String>();
    	
    	try {
    	    	
    		InputManager inputManager = new InputManagerImpl();
    		List<ProductTaxInfoItem> dataItems = inputManager.buildDataItems(inputItems);

    		OutputManager outputManager = new OutputManagerImpl();
    		result=outputManager.printReceipt(dataItems);
    		    		
    		
    	}
    	catch (Exception e){
    		ReceiptGeneratorStandardExceptionHandler.handleException(e);
    	}
    	
    	return result;
    	
    }
}
