package com.dumas.retail.api.product.details;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.dumas.retail.api.client.RedSkyClient;
import com.dumas.retail.api.domain.RetailProduct;
import com.dumas.retail.api.domain.RetailProductRepository;
import com.dumas.retail.api.pojos.ProductDetails;

@RunWith(MockitoJUnitRunner.class)
public class ProductDetailsServiceTest {
	
	@Mock
	private RedSkyClient redSkyClient;
	
	@Mock
	private RetailProductRepository retailProductRepository;
	
	@InjectMocks
	ProductDetailsService productDetailsService;
	
	@Before
	public void setUp() {
		doReturn(ProductDetailsConstants.PRODUCT_NAME).when(redSkyClient).retrieveProductName();
		doReturn(Optional.of(new RetailProduct(Integer.valueOf(ProductDetailsConstants.PRODUCT_ID), ProductDetailsConstants.PRICE,
				ProductDetailsConstants.PRODUCT_NAME, ProductDetailsConstants.CURRENCY_CODE))).when(retailProductRepository).findByProductId(any(Integer.class));
	}

	@Test
	public void test_retrieveNewProductDetails() {
		ProductDetails productDetails = productDetailsService.retrieveProductDetails(ProductDetailsConstants.PRODUCT_ID);
		assertNotNull(productDetails);
		assertEquals(ProductDetailsConstants.PRODUCT_NAME, productDetails.getName());
	}
}
