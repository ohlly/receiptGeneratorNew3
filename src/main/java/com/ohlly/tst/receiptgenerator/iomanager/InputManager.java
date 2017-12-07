package com.ohlly.tst.receiptgenerator.iomanager;

import java.util.List;

import com.ohlly.tst.receiptgenerator.model.ProductTaxInfoItem;

public interface InputManager {

	public List<ProductTaxInfoItem> buildDataItems(List<String> inputLines);
	
}
