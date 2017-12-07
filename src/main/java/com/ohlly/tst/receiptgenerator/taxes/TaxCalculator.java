package com.ohlly.tst.receiptgenerator.taxes;

import java.math.BigDecimal;

import com.ohlly.tst.receiptgenerator.model.taxes.Tax;
import com.ohlly.tst.receiptgenerator.model.taxes.TaxFactory;
import com.ohlly.tst.receiptgenerator.model.taxes.TaxType;

public class TaxCalculator {

	
	
	public  BigDecimal calculate(String productName, BigDecimal taxableAmount, boolean importedProduct){
		
		
		TaxFactory taxFactory = new TaxFactory();
		TaxUtils taxUtils = new TaxUtilsImpl();
		
		Tax importTax = taxFactory.createTax(TaxType.IMPORT);
		Tax salesTax = taxFactory.createTax(TaxType.SALES);
		
		BigDecimal salesTaxAmount =new BigDecimal(0);
		BigDecimal importTaxAmount =new BigDecimal(0);
		
		if (taxUtils.isTaxable(TaxType.SALES, productName)){
			salesTaxAmount=salesTax.calculcate(taxableAmount);
		}
		
		if (importedProduct){
			importTaxAmount=importTax.calculcate(taxableAmount);
		}
		
		return salesTaxAmount.add(importTaxAmount);
	}
	
	
	
}
