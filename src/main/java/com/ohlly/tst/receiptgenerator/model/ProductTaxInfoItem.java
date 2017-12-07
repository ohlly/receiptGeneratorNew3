package com.ohlly.tst.receiptgenerator.model;

import java.math.BigDecimal;

public class ProductTaxInfoItem {

	private String productName;
	private BigDecimal quantity;
	private boolean imported;
	private BigDecimal taxableAmountForEach;
	private BigDecimal taxesAmountForEach;
	
	
	public BigDecimal getTotalTaxesAmount(){
		if (taxesAmountForEach==null)
		{
			taxesAmountForEach=new BigDecimal(0);
		}
		return taxesAmountForEach.multiply(quantity);
	}
	
	public BigDecimal getTotalTaxableAmount(){
		if (taxableAmountForEach==null)
		{
			taxableAmountForEach=new BigDecimal(0);
		}
		return taxableAmountForEach.multiply(quantity);
	}
	
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public boolean isImported() {
		return imported;
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}
	public BigDecimal getTaxableAmountForEach() {
		return taxableAmountForEach;
	}
	public void setTaxableAmountForEach(BigDecimal taxableAmount) {
		this.taxableAmountForEach = taxableAmount;
	}
	public BigDecimal getTaxesAmountForEach() {
		return taxesAmountForEach;
	}
	public void setTaxesAmountForEach(BigDecimal taxesAmount) {
		this.taxesAmountForEach = taxesAmount;
	}
	
	
	
	@Override
	public boolean equals(Object other) {
	    if (!(other instanceof ProductTaxInfoItem)) {
	        return false;
	    }

	    ProductTaxInfoItem that = (ProductTaxInfoItem) other;

	   
	    return this.productName.equals(that.productName)
	      
	        && ((this.quantity!=null && this.quantity.equals(that.quantity)) || this.quantity== that.quantity)
	        && ((this.taxableAmountForEach!=null && this.taxableAmountForEach.equals(that.taxableAmountForEach)) || this.taxableAmountForEach == that.taxableAmountForEach)
	        && ((this.taxesAmountForEach!=null && this.taxesAmountForEach.equals(that.taxesAmountForEach)) || this.taxesAmountForEach== that.taxesAmountForEach)
	        && this.imported== that.imported;
	}
}
