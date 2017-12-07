package com.ohlly.tst.receiptgenerator.taxes;

import java.util.List;

import com.ohlly.tst.receiptgenerator.model.ProductCategory;
import com.ohlly.tst.receiptgenerator.model.taxes.TaxType;
import com.ohlly.tst.receiptgenerator.product.ProductsInfo;
import com.ohlly.tst.receiptgenerator.product.ProductsInfoStandardImpl;

public abstract class TaxUtils {

	protected List<ProductCategory> nonTaxableCategories;

	public abstract void LoadNonTaxableCategories();

	public TaxUtils() {

		LoadNonTaxableCategories();
	}

	public ProductCategory getCategory(String productName) {

		ProductsInfo productsInfo = ProductsInfoStandardImpl.getInstance();
		return productsInfo.getProductCategoriesMap().get(productName);
	};

	public boolean isTaxable(TaxType taxType, String productName) {

		if (taxType == TaxType.SALES && nonTaxableCategories.contains(getCategory(productName))) {
			return false;
		} else {
			return true;
		}

	}

}
