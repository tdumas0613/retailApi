package com.dumas.retail.api.product.details;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.dumas.retail.api.client.RedSkyClient;
import com.dumas.retail.api.pojos.ProductDetails;

@RunWith(MockitoJUnitRunner.class)
public class ProductDetailsServiceTest {
	
	@Mock
	RedSkyClient redSkyClient;
	
	@InjectMocks
	ProductDetailsService productDetailsService;

	@Test
	public void test_retrieveNewProductDetails() {
		doReturn(ProductDetailsConstants.PRODUCT_NAME).when(redSkyClient).retrieveProductName();
		ProductDetails productDetails = productDetailsService.retrieveProductDetails(ProductDetailsConstants.PRODUCT_ID);
		assertNotNull(productDetails);
		assertEquals(ProductDetailsConstants.PRODUCT_NAME, productDetails.getName());
	}
}
