package com.ohlly.tst.receiptgenerator.product;

import java.util.HashMap;

import com.ohlly.tst.receiptgenerator.model.ProductCategory;

public class ProductsInfoStandardImpl extends ProductsInfo {

	private static ProductsInfoStandardImpl instance = new ProductsInfoStandardImpl();
	
	public static ProductsInfoStandardImpl getInstance(){
		
		return instance;
	}
	
	
	private ProductsInfoStandardImpl(){
		productCategoriesMap = new HashMap<String,ProductCategory>();
		loadProductCategoriesMap();
	}
	
	
	
	@Override
	public void loadProductCategoriesMap() {
		
		productCategoriesMap.put("packet of headache pills", ProductCategory.MEDICINAL);
		productCategoriesMap.put("book", ProductCategory.BOOK);
		productCategoriesMap.put("music CD", ProductCategory.OTHER);
		productCategoriesMap.put("chocolate", ProductCategory.FOOD);
		productCategoriesMap.put("box of chocolates", ProductCategory.FOOD);
		productCategoriesMap.put("bottle of perfume",ProductCategory.OTHER);
		productCategoriesMap.put("chocolate bar",ProductCategory.FOOD);

	}

}
