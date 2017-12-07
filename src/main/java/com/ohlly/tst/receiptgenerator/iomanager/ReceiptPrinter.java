package com.ohlly.tst.receiptgenerator.iomanager;

import java.util.List;

import com.ohlly.tst.receiptgenerator.model.ReceiptItem;

public interface ReceiptPrinter {

	public List<String> printReceipt(List<ReceiptItem> receiptItems);
}
