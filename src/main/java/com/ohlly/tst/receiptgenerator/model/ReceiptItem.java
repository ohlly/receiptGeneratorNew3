package com.ohlly.tst.receiptgenerator.model;

import java.math.BigDecimal;

public class ReceiptItem {

	private String description;
	private BigDecimal amount;
	private BigDecimal quantity;
	
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	@Override
	public boolean equals(Object other) {
	    if (!(other instanceof ReceiptItem)) {
	        return false;
	    }

	    ReceiptItem that = (ReceiptItem) other;

	   
	    return this.description.equals(that.description)
	        && this.amount.equals(that.amount) 
	        && this.quantity==null?that.quantity==null:this.quantity.equals(that.quantity);
	}
}
