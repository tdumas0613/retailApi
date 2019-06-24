package com.dumas.retail.api.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDetails {
	
	private long id;
	private String name;
	@JsonProperty("current_price")
	private CurrentPrice currentPrice;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CurrentPrice getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}
}
