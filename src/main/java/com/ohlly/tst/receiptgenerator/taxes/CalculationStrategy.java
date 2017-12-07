package com.ohlly.tst.receiptgenerator.taxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculationStrategy {

	public static BigDecimal simplePercentageRoundedUp(float percentage, BigDecimal taxable) {
		BigDecimal res = new BigDecimal(0);
		BigDecimal notYetRounded = new BigDecimal(0);

		notYetRounded = (taxable.multiply(new BigDecimal(percentage))).divide(new BigDecimal(100));
		res = round(notYetRounded, new BigDecimal("0.05"), RoundingMode.UP);

		return res;
	}

	public static BigDecimal round(BigDecimal value, BigDecimal increment, RoundingMode roundingMode) {
		if (increment.signum() == 0) {
			return value;
		} else {
			BigDecimal divided = value.divide(increment, 0, roundingMode);
			BigDecimal result = divided.multiply(increment);
			return result;
		}
	}

}
