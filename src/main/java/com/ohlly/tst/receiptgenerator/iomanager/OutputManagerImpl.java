package com.ohlly.tst.receiptgenerator.iomanager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ohlly.tst.receiptgenerator.model.ProductTaxInfoItem;
import com.ohlly.tst.receiptgenerator.model.ReceiptItem;

public class OutputManagerImpl implements OutputManager {

	private BigDecimal totalTaxes = new BigDecimal(0);
	private BigDecimal totalAmount = new BigDecimal(0);

	public List<ReceiptItem> buildOutputItems(List<ProductTaxInfoItem> dataItems) {

		List<ReceiptItem> res = new ArrayList<ReceiptItem>();

		res.addAll(createReceiptItemForEachProductTaxInfoItem(dataItems));

		res.add(createSalesTaxesItem(totalTaxes));
		res.add(createTotalItem(totalAmount));

		return res;
	}

	private ReceiptItem createSalesTaxesItem(BigDecimal totalTaxes) {
		ReceiptItem res = new ReceiptItem();

		res.setAmount(totalTaxes);
		res.setDescription(IoLabels.SALES_TAXES);

		return res;
	}

	private ReceiptItem createTotalItem(BigDecimal totalAmount) {
		ReceiptItem res = new ReceiptItem();

		res.setAmount(totalAmount);
		res.setDescription(IoLabels.TOTAL);

		return res;
	}

	private List<ReceiptItem> createReceiptItemForEachProductTaxInfoItem(List<ProductTaxInfoItem> dataItems) {

		List<ReceiptItem> res = new ArrayList<ReceiptItem>();
		if (dataItems != null && !dataItems.isEmpty()) {
			for (ProductTaxInfoItem dataItem : dataItems) {
				ReceiptItem receiptItem = new ReceiptItem();
				receiptItem.setAmount(dataItem.getTotalTaxableAmount().add(dataItem.getTotalTaxesAmount()));
				receiptItem.setDescription((dataItem.isImported() ? "imported " : "") + dataItem.getProductName());
				receiptItem.setQuantity(dataItem.getQuantity());
				totalTaxes = totalTaxes.add(dataItem.getTotalTaxesAmount());
				totalAmount = totalAmount.add(dataItem.getTotalTaxableAmount().add(dataItem.getTotalTaxesAmount()));
				res.add(receiptItem);
			}

		}
		return res;
	}

	public List<String> printReceipt(List<ProductTaxInfoItem> dataItems) {

		ReceiptPrinter receiptPrinter = new ReceiptPrinterImpl();
		List<ReceiptItem> receiptItemList = buildOutputItems(dataItems);
		return receiptPrinter.printReceipt(receiptItemList);

	}

}
