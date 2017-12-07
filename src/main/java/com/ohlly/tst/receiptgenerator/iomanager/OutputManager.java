package com.ohlly.tst.receiptgenerator.iomanager;

import java.util.List;

import com.ohlly.tst.receiptgenerator.model.ProductTaxInfoItem;
import com.ohlly.tst.receiptgenerator.model.ReceiptItem;

public interface OutputManager {

	public List<ReceiptItem> buildOutputItems(List<ProductTaxInfoItem> inputLines);

	public List<String> printReceipt(List<ProductTaxInfoItem> dataItems);
	
}
