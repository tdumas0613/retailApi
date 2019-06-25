package com.dumas.retail.api.domain;

import org.springframework.data.annotation.Id;

public class RetailProduct {
	
	@Id
	private String productId;
	private double price;
	private String name;
	private String currencyCode;
	
	public RetailProduct(String productId, double price, String name, String currencyCode) {
		super();
		this.productId = productId;
		this.price = price;
		this.name = name;
		this.currencyCode = currencyCode;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	@Override
    public String toString() {
        return String.format(
                "RetailProduct[id=%s, price='%s', name='%s']",
                productId, price, name);
    }
}
