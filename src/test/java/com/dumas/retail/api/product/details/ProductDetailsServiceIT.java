package com.dumas.retail.api.product.details;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dumas.retail.api.ApplicationTests;
import com.dumas.retail.api.domain.RetailProduct;
import com.dumas.retail.api.pojos.CurrentPrice;
import com.dumas.retail.api.pojos.ProductDetails;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDetailsServiceIT extends ApplicationTests {
	
	@Autowired
	private ProductDetailsService productDetailsService;
	
	@Test
	public void test_retrieveNewProductDetails() {
		ProductDetails productDetails = productDetailsService.retrieveProductDetails(ProductDetailsTestUtility.PRODUCT_ID);
		assertEquals(ProductDetailsTestUtility.PRODUCT_ID, productDetails.getId());
		assertEquals(ProductDetailsTestUtility.PRODUCT_NAME, productDetails.getName());
		assertNotNull(productDetails.getCurrentPrice());
	}
	
	@Test
	public void test_establishCurrentPrice() {
		CurrentPrice currentPrice = productDetailsService.establishCurrentPrice(Integer.valueOf(ProductDetailsTestUtility.PRODUCT_ID));
		assertNotNull(currentPrice.getValue());
		assertNotNull(currentPrice.getCurrencyCode());
	}
	
	@Test
	public void test_updateProductDetails() {
		RetailProduct retailProduct = establishBasePrice(ProductDetailsTestUtility.PRICE);
		assertEquals(ProductDetailsTestUtility.PRICE, retailProduct.getPrice());
		RetailProduct updatedRetailProduct = productDetailsService.updateProductPrice(Integer.valueOf(ProductDetailsTestUtility.PRODUCT_ID), ProductDetailsTestUtility.createProductDetails(
				ProductDetailsTestUtility.PRODUCT_ID, ProductDetailsTestUtility.UPDATED_PRICE));
		assertNotNull(updatedRetailProduct);
		assertEquals(ProductDetailsTestUtility.UPDATED_PRICE, updatedRetailProduct.getPrice());
		establishBasePrice(ProductDetailsTestUtility.PRICE);
	}
	
	@Test
	public void test_updateProductPrice() {
		RetailProduct retailProduct = establishBasePrice(ProductDetailsTestUtility.PRICE);
		assertEquals(ProductDetailsTestUtility.PRICE, retailProduct.getPrice());
		RetailProduct updatedRetailProduct = productDetailsService.updateProductPrice(Integer.valueOf(ProductDetailsTestUtility.PRODUCT_ID),
				ProductDetailsTestUtility.createProductDetails(ProductDetailsTestUtility.PRODUCT_ID, ProductDetailsTestUtility.UPDATED_PRICE));
		assertNotNull(updatedRetailProduct);
		assertEquals(ProductDetailsTestUtility.UPDATED_PRICE, updatedRetailProduct.getPrice());
		establishBasePrice(ProductDetailsTestUtility.PRICE);
	}

	private RetailProduct establishBasePrice(Double basePrice) {
		RetailProduct retailProduct = productDetailsService.updateProductPrice(Integer.valueOf(ProductDetailsTestUtility.PRODUCT_ID), ProductDetailsTestUtility.createProductDetails(
				ProductDetailsTestUtility.PRODUCT_ID, basePrice));
		return retailProduct;
	}
}
