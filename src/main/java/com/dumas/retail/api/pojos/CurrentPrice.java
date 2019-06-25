package com.dumas.retail.api.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentPrice {
	
	private double value;
	@JsonProperty("currency_code")
	private String currencyCode;
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
