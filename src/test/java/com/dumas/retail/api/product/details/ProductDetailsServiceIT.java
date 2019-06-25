package com.dumas.retail.api.product.details;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dumas.retail.api.ApplicationTests;
import com.dumas.retail.api.domain.RetailProduct;
import com.dumas.retail.api.domain.RetailProductRepository;
import com.dumas.retail.api.pojos.CurrentPrice;
import com.dumas.retail.api.pojos.ProductDetails;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDetailsServiceIT extends ApplicationTests {
	
	@Autowired
	private ProductDetailsService productDetailsService;
	
	@Autowired
	private RetailProductRepository retailProductRepository;
	
	private static final String PRODUCT_ID = "123";
	
	@Before
	public void saveNewRetailProduct() {
		retailProductRepository.save(new RetailProduct(
				ProductDetailsConstants.PRODUCT_ID, 10.95, ProductDetailsConstants.PRODUCT_NAME, ProductDetailsConstants.CURRENCY_CODE));
	}
	
	@After
	public void deleteAllRetailProducts() {
		retailProductRepository.deleteAll();
	}
	
	@Test
	public void test_retrieveNewProductDetails() {
		ProductDetails productDetails = productDetailsService.retrieveProductDetails(PRODUCT_ID);
		assertEquals(ProductDetailsConstants.PRODUCT_ID, productDetails.getId());
		assertEquals(ProductDetailsConstants.PRODUCT_NAME, productDetails.getName());
		assertNotNull(productDetails.getCurrentPrice());
	}
	
	@Test
	public void test_establishCurrentPrice() {
		CurrentPrice currentPrice = productDetailsService.establishCurrentPrice(ProductDetailsConstants.PRODUCT_ID);
		assertNotNull(currentPrice.getValue());
		assertNotNull(currentPrice.getCurrencyCode());
	}
}
