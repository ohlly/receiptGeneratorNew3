package com.ohlly.tst.receiptgenerator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ohlly.tst.receiptgenerator.iomanager.Parser;

public class ParserJunitTest {


	@Test
	public void parseTestHappy() {

		Parser parser = new Parser();
		

		parser.parse("1 box of imported chocolates at 11.25");
		assertEquals(parser.getAmount(), new BigDecimal( 11.25));
		assertEquals(parser.getProductName(), "box of chocolates");
		assertEquals(parser.getQuantity(), new BigDecimal(1));
		assert (parser.isImportedProduct());
		
		parser.parse("1 packet of headache pills at 9.75");
		assertEquals(parser.getAmount(), new BigDecimal(9.75));
		assertEquals(parser.getProductName(), "packet of headache pills");
		assertEquals(parser.getQuantity(), new BigDecimal(1));
		assert (!parser.isImportedProduct());

		parser.parse("1 imported box of chocolates at 10.00");

		assertEquals(parser.getAmount(), new BigDecimal(10));
		assertEquals(parser.getProductName(), "box of chocolates");
		assertEquals(parser.getQuantity(), new BigDecimal(1));
		assert (parser.isImportedProduct());

		
	}

	@Test
	public void parseBadTestProductNotValid() {

		Parser parser = new Parser();
		parser.parse("1 xxx of headache pills at 9.75");

		assertEquals(parser.getAmount(), new BigDecimal(9.75));
		assertEquals(parser.getProductName(), "");
		assertEquals(parser.getQuantity(), new BigDecimal(1));
		assert (!parser.isImportedProduct());

	}

	@Test
	public void parseBadTestQuantityMissing() {

		Parser parser = new Parser();
		parser.parse("1 imported box of chocolates at dd");

		assertEquals(parser.getAmount(), null);
		assertEquals(parser.getProductName(), "box of chocolates");
		assertEquals(parser.getQuantity(), new BigDecimal(1));
		assert (parser.isImportedProduct());

	}

}
