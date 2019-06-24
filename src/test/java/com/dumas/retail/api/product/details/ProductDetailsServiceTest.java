package com.dumas.retail.api.product.details;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.dumas.retail.api.clients.RedSkyClient;
import com.dumas.retail.api.pojos.CurrentPrice;
import com.dumas.retail.api.pojos.ProductDetails;

@RunWith(MockitoJUnitRunner.class)
public class ProductDetailsServiceTest {
	
	@Mock
	RedSkyClient redSkyClient;
	
	@InjectMocks
	ProductDetailsService productDetailsService;

	@Test
	public void test_retrieveNewProductDetails() {
		doReturn("redSky").when(redSkyClient).retrieveProductName();
		ProductDetails productDetails = productDetailsService.retrieveProductDetails(ProductDetailsConstants.PRODUCT_ID);
		assertNotNull(productDetails);
	}
	
	@Test
	public void test_createNewCurrentPrice() {
		CurrentPrice currentPrice = productDetailsService.createCurrentPrice(ProductDetailsConstants.VALUE, ProductDetailsConstants.CURRENCY_CODE);
		assertNotNull(currentPrice);
	}
}
