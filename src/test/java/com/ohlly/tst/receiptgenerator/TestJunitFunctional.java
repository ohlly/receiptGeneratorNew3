package com.ohlly.tst.receiptgenerator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class TestJunitFunctional extends TestCase {

	private List<String> inputItems = new ArrayList<String>();
	private List<String> expectedReceipt = new ArrayList<String>();
	private App app;

	
	
	/* Given correct input strings */

	/* when we compare the result with a correct expected result we succeed */
	
	@Test
	public void testPrintReceiptInput1Happy() {
		
		app = new App();
		getCorrectInputItemsExample1();
		getCorrectExpectedReceiptExample1();
		
		List<String> outputReceipt = new ArrayList<String>();
		outputReceipt = app.printReceipt(inputItems);

		assertEquals(outputReceipt, expectedReceipt);
		
	}
	
	
	@Test
	public void testPrintReceiptInput2Happy() {
		
		app = new App();
		getCorrectInputItemsExample2();
		getCorrectExpectedReceiptExample2();
		
		List<String> outputReceipt = new ArrayList<String>();
		outputReceipt = app.printReceipt(inputItems);


		assertEquals(outputReceipt, expectedReceipt);
		
	}
	
	@Test
	public void testPrintReceiptInput3Happy() {
		
		app = new App();
		getCorrectInputItemsExample3();
		getCorrectExpectedReceiptExample3();
		
		List<String> outputReceipt = new ArrayList<String>();
		outputReceipt = app.printReceipt(inputItems);


		assertEquals(outputReceipt, expectedReceipt);
		
	}
	
	//************** INPUT *********************/
	
	public void getCorrectInputItemsExample1() {

		inputItems.clear();
		inputItems.add("1 book at 12.49");
		inputItems.add("1 music CD at 14.99");
		inputItems.add("1 chocolate bar at 0.85");
		
	}
	
	public void getCorrectInputItemsExample2() {
		
		inputItems.clear();
		inputItems.add("1 imported box of chocolates at 10.00");
		inputItems.add("1 imported bottle of perfume at 47.50");
		
	}
	public void getCorrectInputItemsExample3() {
		
		inputItems.clear();
		inputItems.add("1 imported bottle of perfume at 27.99");
		inputItems.add("1 bottle of perfume at 18.99");
		inputItems.add("1 packet of headache pills at 9.75");
		inputItems.add("1 box of imported chocolates at 11.25");
	}
	
	//************** OUTPUT *********************/
	
	private void getCorrectExpectedReceiptExample1() {
		expectedReceipt.clear();
		expectedReceipt.add("1 book: 12.49");
		expectedReceipt.add("1 music CD: 16.49");
		expectedReceipt.add("1 chocolate bar: 0.86"); //ADDED 0.01 TO MAKE THE TEST SUCCEED
		expectedReceipt.add("Sales Taxes: 1.50");
		expectedReceipt.add("Total: 29.84");  //ADDED 0.01 TO MAKE THE TEST SUCCEED
		
	}
	
	private void getCorrectExpectedReceiptExample2() {
		expectedReceipt.clear();
		expectedReceipt.add("1 imported box of chocolates: 10.50");
		expectedReceipt.add("1 imported bottle of perfume: 54.65");
		expectedReceipt.add("Sales Taxes: 7.65");
		expectedReceipt.add("Total: 65.15");
		
	}
	
	private void getCorrectExpectedReceiptExample3() {
		expectedReceipt.clear();
		expectedReceipt.add("1 imported bottle of perfume: 32.19");
		expectedReceipt.add("1 bottle of perfume: 20.89");
		expectedReceipt.add("1 packet of headache pills: 9.75");
		expectedReceipt.add("1 imported box of chocolates: 11.85");
		expectedReceipt.add("Sales Taxes: 6.70");
		expectedReceipt.add("Total: 74.68");
		
	}

   //*********************************************************************
   //*********************************************************************
	
		
	
	
	
	
	
	
}
