package com.ohlly.tst.receiptgenerator.product;

import java.util.Map;

import com.ohlly.tst.receiptgenerator.model.ProductCategory;

public abstract class ProductsInfo {

	
	protected Map<String,ProductCategory> productCategoriesMap;
	public abstract void loadProductCategoriesMap();
	
		
	
	public Map<String, ProductCategory> getProductCategoriesMap() {
		return productCategoriesMap;
	}
	public void setProductCategoriesMap(Map<String, ProductCategory> productCategoriesMap) {
		this.productCategoriesMap = productCategoriesMap;
	}
	
	
}
