package com.ohlly.tst.receiptgenerator.taxes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ohlly.tst.receiptgenerator.model.ProductCategory;

public class TaxUtilsImpl extends TaxUtils {

	
	
	

	@Override
	public void LoadNonTaxableCategories() {
		
		nonTaxableCategories = new ArrayList<ProductCategory>();
		nonTaxableCategories.add(ProductCategory.BOOK);
		nonTaxableCategories.add(ProductCategory.MEDICINAL);
		nonTaxableCategories.add(ProductCategory.FOOD);

	}

}
