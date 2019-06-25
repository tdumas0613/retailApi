package com.dumas.retail.api.product.details;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dumas.retail.api.ApplicationTests;
import com.dumas.retail.api.pojos.ProductDetails;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDetailsServiceIT extends ApplicationTests {
	
	@Autowired
	private ProductDetailsService productDetailsService;
	
	private static final String PRODUCT_ID = "123";
	
	@Test
	public void test_retrieveNewProductDetails() {
		ProductDetails productDetails = productDetailsService.retrieveProductDetails(PRODUCT_ID);
		assertNotNull(productDetails);
	}
}
