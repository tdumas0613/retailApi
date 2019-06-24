package com.dumas.retail.api.product.details;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dumas.retail.api.pojos.CurrentPrice;
import com.dumas.retail.api.pojos.ProductDetails;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDetailsServiceIT {
	
	@Autowired
	private ProductDetailsService productDetailsService;
	
	private static final long PRODUCT_ID = 15117729;
	
	@Test
	public void test_retrieveNewProductDetails() {
		ProductDetails productDetails = productDetailsService.retrieveProductDetails(PRODUCT_ID);
		assertNotNull(productDetails);
	}
	
	@Test
	public void test_createNewCurrentPrice() {
		CurrentPrice currentPrice = productDetailsService.createCurrentPrice(ProductDetailsConstants.VALUE, ProductDetailsConstants.CURRENCY_CODE);
		assertNotNull(currentPrice);
	}
}
