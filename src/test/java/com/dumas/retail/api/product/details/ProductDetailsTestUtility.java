package com.dumas.retail.api.product.details;

import com.dumas.retail.api.pojos.CurrentPrice;
import com.dumas.retail.api.pojos.ProductDetails;

public class ProductDetailsTestUtility {
	
	public static final String PRODUCT_ID = "15117729";
	public static final String DIFFERING_PRODUCT_ID = "123";
	public static final String PRODUCT_NAME = "The Big Lebowski (Blu-ray)";
	public static final String CURRENCY_CODE = "USD";
	public static final Double PRICE = 10.95;
	public static final Double UPDATED_PRICE = 20.99;
	
	public static ProductDetails createProductDetails(String productId, Double productPrice) {
		ProductDetails productDetails = new ProductDetails();
		productDetails.setCurrentPrice(createCurrentPrice(productPrice, ProductDetailsTestUtility.CURRENCY_CODE));
		productDetails.setId(productId);
		productDetails.setName(ProductDetailsTestUtility.PRODUCT_NAME);
		return productDetails;
	}
	
	private static CurrentPrice createCurrentPrice(Double value, String currencyCode) {
		CurrentPrice currentPrice = new CurrentPrice();
		currentPrice.setValue(value);
		currentPrice.setCurrencyCode(currencyCode);
		return currentPrice;
	}

}
