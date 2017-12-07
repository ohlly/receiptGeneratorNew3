package com.ohlly.tst.receiptgenerator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.ohlly.tst.receiptgenerator.taxes.CalculationStrategy;
import com.ohlly.tst.receiptgenerator.taxes.TaxCalculator;

public class TaxCalculatorJunitTest {

	@Test
	public void calculateAppyTest() {

		TaxCalculator calculator = new TaxCalculator();

		BigDecimal value = calculator.calculate("music CD", new BigDecimal(14.99), false);
		BigDecimal expectedValue = new BigDecimal(16.49 - 14.99);
		assertEquals(value, CalculationStrategy.round(expectedValue, new BigDecimal("0.05"), RoundingMode.UP));

		value = calculator.calculate("bottle of perfume", new BigDecimal(27.99), true);
		expectedValue = new BigDecimal(32.19 - 27.99);
		assertEquals(value, CalculationStrategy.round(expectedValue, new BigDecimal("0.05"), RoundingMode.UP));

	}

}
