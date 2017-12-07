package com.ohlly.tst.receiptgenerator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ohlly.tst.receiptgenerator.iomanager.InputManager;
import com.ohlly.tst.receiptgenerator.iomanager.InputManagerImpl;
import com.ohlly.tst.receiptgenerator.iomanager.OutputManager;
import com.ohlly.tst.receiptgenerator.iomanager.OutputManagerImpl;
import com.ohlly.tst.receiptgenerator.iomanager.ReceiptPrinter;
import com.ohlly.tst.receiptgenerator.iomanager.ReceiptPrinterImpl;
import com.ohlly.tst.receiptgenerator.model.ProductTaxInfoItem;
import com.ohlly.tst.receiptgenerator.model.ReceiptItem;

public class ioManagerJunitTest {

	
	@Test
	public void buildDataItemsTestHappy() {
		
		List<String> inputList = new ArrayList<String>();
		
		inputList.add("1 imported bottle of perfume at 27.99");
		inputList.add("1 bottle of perfume at 18.99");
		
		
		List<ProductTaxInfoItem> resultList = new ArrayList< ProductTaxInfoItem>();
		List<ProductTaxInfoItem> expectedList = new ArrayList< ProductTaxInfoItem>();
		 
		ProductTaxInfoItem dataItem = new ProductTaxInfoItem();
		
		dataItem.setImported(true);
		dataItem.setProductName("bottle of perfume");
		dataItem.setQuantity(new BigDecimal(1));
		dataItem.setTaxableAmountForEach(new BigDecimal(27.99).setScale(2, RoundingMode.HALF_DOWN));
		dataItem.setTaxesAmountForEach(new BigDecimal(32.19-27.99).setScale(2, RoundingMode.HALF_DOWN));
		expectedList.add(dataItem);
		
		dataItem = new ProductTaxInfoItem();
		dataItem.setImported(false);
		dataItem.setProductName("bottle of perfume");
		dataItem.setQuantity(new BigDecimal(1));
		dataItem.setTaxableAmountForEach(new BigDecimal(18.99).setScale(2, RoundingMode.HALF_DOWN));
		dataItem.setTaxesAmountForEach(new BigDecimal(20.89-18.99).setScale(2, RoundingMode.HALF_DOWN));
		expectedList.add(dataItem);
		
		InputManager inputManager = new InputManagerImpl();
		resultList = inputManager.buildDataItems(inputList);
		
		assertEquals(resultList,expectedList);
		 
		
	}

	@Test
	public void buildReceiptItemsTestHappy() {
				
		OutputManager outputManager = new OutputManagerImpl();
		List<ProductTaxInfoItem> dataItemList = new ArrayList<ProductTaxInfoItem>();
		
		
		ProductTaxInfoItem dataItem = new ProductTaxInfoItem();
		
		dataItem.setImported(true);
		dataItem.setProductName("bottle of perfume");
		dataItem.setQuantity(new BigDecimal(1));
		dataItem.setTaxableAmountForEach(new BigDecimal(27.99).setScale(2, RoundingMode.UP));
		dataItem.setTaxesAmountForEach(new BigDecimal(32.19-27.99).setScale(2, RoundingMode.UP));
		dataItemList.add(dataItem);
		
		dataItem = new ProductTaxInfoItem();
		dataItem.setImported(false);
		dataItem.setProductName("bottle of perfume");
		dataItem.setQuantity(new BigDecimal(1));
		dataItem.setTaxableAmountForEach(new BigDecimal(18.99).setScale(2, RoundingMode.UP));
		dataItem.setTaxesAmountForEach(new BigDecimal(20.89-18.99).setScale(2, RoundingMode.UP));
		dataItemList.add(dataItem);
		
		dataItem = new ProductTaxInfoItem();
		dataItem.setImported(false);
		dataItem.setProductName("packet of headache pills");
		dataItem.setQuantity(new BigDecimal(1));
		dataItem.setTaxableAmountForEach(new BigDecimal(9.75).setScale(2, RoundingMode.UP));
		dataItem.setTaxesAmountForEach(new BigDecimal(9.75-9.75).setScale(2, RoundingMode.UP));
		dataItemList.add(dataItem);
		
		dataItem = new ProductTaxInfoItem();
		dataItem.setImported(true);
		dataItem.setProductName("box of chocolates");
		dataItem.setQuantity(new BigDecimal(1));
		dataItem.setTaxableAmountForEach(new BigDecimal(11.25).setScale(2, RoundingMode.UP));
		dataItem.setTaxesAmountForEach(new BigDecimal(11.85-11.25).setScale(2, RoundingMode.UP));
		dataItemList.add(dataItem);
		
		
		List<ReceiptItem> expectedList = new ArrayList<ReceiptItem>();
		
		ReceiptItem item = new ReceiptItem();
		item.setDescription("imported bottle of perfume");
		item.setQuantity(new BigDecimal(1));
		item.setAmount(new BigDecimal(32.19).setScale(2, RoundingMode.UP));
		expectedList.add(item);
		
		item = new ReceiptItem();
		item.setQuantity(new BigDecimal(1));
		item.setDescription("bottle of perfume");
		item.setAmount(new BigDecimal(20.89).setScale(2, RoundingMode.UP));
		expectedList.add(item);
		
		item = new ReceiptItem();
		item.setQuantity(new BigDecimal(1));
		item.setDescription("packet of headache pills");
		item.setAmount(new BigDecimal(9.75).setScale(2, RoundingMode.UP));
		expectedList.add(item);
		
		item = new ReceiptItem();
		item.setQuantity(new BigDecimal(1));
		item.setDescription("imported box of chocolates");
		item.setAmount(new BigDecimal(11.85).setScale(2, RoundingMode.UP));
		expectedList.add(item);
		
		item = new ReceiptItem();
		item.setDescription("Sales Taxes");
		item.setAmount(new BigDecimal(6.70).setScale(2, RoundingMode.UP));
		expectedList.add(item);
		
		item = new ReceiptItem();
		item.setDescription("Total");
		item.setAmount(new BigDecimal(74.68).setScale(2, RoundingMode.UP));
		expectedList.add(item);
		
		List<ReceiptItem> resultList = outputManager.buildOutputItems(dataItemList);
		
		assertEquals(resultList,expectedList);
	}
	
	
	@Test
	public void printReceiptItemsTestHappy() {
		
		List<ReceiptItem> inputList = new ArrayList<ReceiptItem>();
		
		ReceiptItem item = new ReceiptItem();
		item.setDescription("imported bottle of perfume");
		item.setQuantity(new BigDecimal(1));
		item.setAmount(new BigDecimal(32.19).setScale(2, RoundingMode.HALF_DOWN));
		inputList.add(item);
		
		item = new ReceiptItem();
		item.setQuantity(new BigDecimal(1));
		item.setDescription("bottle of perfume");
		item.setAmount(new BigDecimal(20.89).setScale(2, RoundingMode.HALF_DOWN));
		inputList.add(item);
		
		item = new ReceiptItem();
		item.setQuantity(new BigDecimal(1));
		item.setDescription("packet of headache pills");
		item.setAmount(new BigDecimal(9.75).setScale(2, RoundingMode.HALF_DOWN));
		inputList.add(item);
		
		item = new ReceiptItem();
		item.setQuantity(new BigDecimal(1));
		item.setDescription("imported box of chocolates");
		item.setAmount(new BigDecimal(11.85).setScale(2, RoundingMode.HALF_DOWN));
		inputList.add(item);
		
		item = new ReceiptItem();
		item.setDescription("Sales Taxes");
		item.setAmount(new BigDecimal(6.70).setScale(2, RoundingMode.HALF_DOWN));
		inputList.add(item);
		
		item = new ReceiptItem();
		item.setDescription("Total");
		item.setAmount(new BigDecimal(74.68).setScale(2, RoundingMode.HALF_DOWN));
		inputList.add(item);
		
		List<String> expectedList = new ArrayList<String>();
		
		expectedList.add("1 imported bottle of perfume: 32.19");
		expectedList.add("1 bottle of perfume: 20.89");
		expectedList.add("1 packet of headache pills: 9.75");
		expectedList.add("1 imported box of chocolates: 11.85");
		expectedList.add("Sales Taxes: 6.70");
		expectedList.add("Total: 74.68");
		
		ReceiptPrinter printer = new ReceiptPrinterImpl();
		List<String> resultList = printer.printReceipt(inputList);
		assertEquals(resultList, expectedList );
		
	}
	
}
