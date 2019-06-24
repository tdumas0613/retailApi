package com.dumas.retail.api.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("retail_products")
public class RetailProduct {
	
	private long id;
	private double price;
	private String name;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	@Override
    public String toString() {
        return String.format(
                "RetailProduct[id=%s, price='%s', name='%s']",
                id, price, name);
    }
}
