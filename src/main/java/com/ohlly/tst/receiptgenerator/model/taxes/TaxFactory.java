package com.ohlly.tst.receiptgenerator.model.taxes;

public class TaxFactory {

	public Tax createTax(TaxType taxType) {
		Tax tax = null;

		if (taxType != null) {

			if (taxType == TaxType.IMPORT) {
				tax = ImportTax.getInstance();

			} else if (taxType == TaxType.SALES) {
				tax = SalesTax.getInstance();
			}

		}

		return tax;

	}
}
