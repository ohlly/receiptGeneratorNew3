package com.ohlly.tst.receiptgenerator.model.taxes;

import java.math.BigDecimal;

import com.ohlly.tst.receiptgenerator.taxes.CalculationStrategy;
import com.ohlly.tst.receiptgenerator.taxes.TaxesConstants;

public class ImportTax extends Tax {

	private float percentage;

	private static ImportTax instance = new ImportTax();

	private ImportTax() {
		percentage = TaxesConstants.ImportTaxPercentage;
	};

	public static ImportTax getInstance() {

		return instance;

	};

	@Override
	public BigDecimal calculcate(BigDecimal taxable) {
		BigDecimal ris = new BigDecimal(0);

		ris = CalculationStrategy.simplePercentageRoundedUp(percentage, taxable);

		return ris;
	}

}
