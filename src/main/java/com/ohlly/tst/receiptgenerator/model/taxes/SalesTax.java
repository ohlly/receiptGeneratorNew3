package com.ohlly.tst.receiptgenerator.model.taxes;

import java.math.BigDecimal;

import com.ohlly.tst.receiptgenerator.taxes.CalculationStrategy;
import com.ohlly.tst.receiptgenerator.taxes.TaxesConstants;


public class SalesTax extends Tax {
	
	private float percentage;

	private static SalesTax instance = new SalesTax();

	public static SalesTax getInstance() {
		return instance;
	}

	private SalesTax() {
		percentage = TaxesConstants.SalesTaxPercentage;
	};

	@Override
	public BigDecimal calculcate(BigDecimal taxable) {
		BigDecimal ris = new BigDecimal(0);

		ris = CalculationStrategy.simplePercentageRoundedUp(percentage, taxable);

		return ris;
	}

}
