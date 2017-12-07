package com.ohlly.tst.receiptgenerator.iomanager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ohlly.tst.receiptgenerator.product.ProductsInfo;
import com.ohlly.tst.receiptgenerator.product.ProductsInfoStandardImpl;
import com.ohlly.tst.receiptgenerator.taxes.CalculationStrategy;

public class Parser {

	protected String productName;
	protected BigDecimal amount;
	protected boolean importedProduct;
	protected BigDecimal quantity;

	protected String[] wordsWhichAreNotProducts;

	public void parse(String inputString) {

		reset();
		Scanner sc = new Scanner(inputString);

		inputString.replaceAll("\\s+", " ");

		boolean parserPassedQuantityPosition = false;

		while (sc.hasNext()) {

			if (sc.hasNextInt() && !parserPassedQuantityPosition) {
				quantity = new BigDecimal(sc.nextInt());
			}

			parserPassedQuantityPosition = true;

			String word = sc.next();

			if (word.equals("imported")) {
				importedProduct = true;
			}

			if (word.equals("at")) {

				try {
					amount = (new BigDecimal(Float.parseFloat(sc.next()))).setScale(2, RoundingMode.UP); //xxx
				} catch (NumberFormatException e) {
					System.out.println("Error while parsing amount");
				}

			}

		}

		sc.close();

		productName = getProductName(inputString);

		
	}

	public Parser() {

		loadWordsWhichAreNotProducts();
	}
	
	public void reset(){
		productName="";
		amount = null;
		importedProduct = false;
		quantity = null;
	}

	protected void loadWordsWhichAreNotProducts() {

		wordsWhichAreNotProducts = new String[] { "at", ":",  "imported" };
	}

	protected boolean isNotProduct(String word) {

		boolean found = false;
		for (String wordNotProduct : wordsWhichAreNotProducts) {
			if (wordNotProduct.equals(word)) {
				found = true;
			}
		}
		return found;
	}

	private String getProductName(String inputString) {

		ProductsInfo productsInfo = ProductsInfoStandardImpl.getInstance();
		String[] inputWords = inputString.split(" ");
		
		String guessedProductName = "";
		List<String> previousInputWords = new ArrayList<String>();
		previousInputWords.add("");

		if (inputWords != null && inputWords.length > 0) {
			for (String inputWord : inputWords) {
				if (!isNotProduct(inputWord)) {
					if (productsInfo.getProductCategoriesMap().containsKey(inputWord)) {
						guessedProductName = inputWord;
					} else {
						String newTry = inputWord;
						for (int i = previousInputWords.size() - 1; i >= 0; i--) {
							newTry = previousInputWords.get(i) + " " + newTry;
							if (productsInfo.getProductCategoriesMap().containsKey(newTry)) {
								guessedProductName = newTry;
							}
						}

					}
					previousInputWords.add(inputWord);
				}
				
			}
		}

		return guessedProductName;
	}

	public String getProductName() {
		return productName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public boolean isImportedProduct() {
		return importedProduct;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setImportedProduct(boolean importedProduct) {
		this.importedProduct = importedProduct;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
