package com.dumas.retail.api.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("retail_products")
public class RetailProduct {
	
	@Id
	private String id;
	private double price;
	private String name;
	private String currencyCode;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
                id, price, name);
    }
}
