package com.ohlly.tst.receiptgenerator.iomanager;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.ohlly.tst.receiptgenerator.model.ReceiptItem;

public class ReceiptPrinterImpl implements ReceiptPrinter {

	public List<String> printReceipt(List<ReceiptItem> receiptItems){
		
		 DecimalFormat df = new DecimalFormat("#.##");
		 DecimalFormat dfInt = new DecimalFormat("##");
		List<String> res = new ArrayList<String>();
		
		if (receiptItems!=null && !receiptItems.isEmpty())
		{
			for (ReceiptItem receiptItem:receiptItems)
			{
				String outString = (String) ((receiptItem.getQuantity()!=null?dfInt.format(receiptItem.getQuantity()):"") + " " + receiptItem.getDescription() + ": " + receiptItem.getAmount());
				if (outString.charAt(0)==' '){
					outString=outString.substring(1);
				}
				res.add(outString);
			}
		}
		
		return res;
		
	}
}
