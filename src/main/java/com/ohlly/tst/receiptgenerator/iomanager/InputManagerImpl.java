package com.ohlly.tst.receiptgenerator.iomanager;

import java.util.ArrayList;
import java.util.List;

import com.ohlly.tst.receiptgenerator.model.ProductTaxInfoItem;
import com.ohlly.tst.receiptgenerator.taxes.TaxCalculator;

public class InputManagerImpl implements InputManager {

	public List<ProductTaxInfoItem> buildDataItems(List<String> inputLines) {
		
		List<ProductTaxInfoItem> res = new ArrayList<ProductTaxInfoItem>();
		Parser parser = new Parser();
		TaxCalculator taxCalculator = new TaxCalculator();
		if (inputLines!=null && !inputLines.isEmpty())
		{
		for (String inputString:inputLines){
			parser.parse(inputString);
			
			ProductTaxInfoItem item = new ProductTaxInfoItem();
			item.setProductName(parser.getProductName());
			item.setImported(parser.isImportedProduct());
			item.setTaxableAmountForEach(parser.getAmount());
			item.setTaxesAmountForEach(taxCalculator.calculate(parser.getProductName(),parser.getAmount(),parser.isImportedProduct()));
			item.setQuantity(parser.getQuantity());
			res.add(item);
		}
		}
		
		
		
		return res;
	}

}
