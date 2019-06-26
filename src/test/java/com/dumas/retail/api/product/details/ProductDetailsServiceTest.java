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
import com.dumas.retail.api.pojos.CurrentPrice;
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
		doReturn(ProductDetailsTestUtility.PRODUCT_NAME).when(redSkyClient).retrieveProductName();
		doReturn(Optional.of(new RetailProduct(Integer.valueOf(ProductDetailsTestUtility.PRODUCT_ID), ProductDetailsTestUtility.PRICE,
				ProductDetailsTestUtility.PRODUCT_NAME, ProductDetailsTestUtility.CURRENCY_CODE))).when(retailProductRepository).findByProductId(any(Integer.class));
		
		doReturn(new RetailProduct(Integer.valueOf(ProductDetailsTestUtility.PRODUCT_ID), ProductDetailsTestUtility.UPDATED_PRICE,
				ProductDetailsTestUtility.PRODUCT_NAME, ProductDetailsTestUtility.CURRENCY_CODE)).when(retailProductRepository).save(any(RetailProduct.class));
	}

	@Test
	public void test_retrieveNewProductDetails() {
		ProductDetails productDetails = productDetailsService.retrieveProductDetails(ProductDetailsTestUtility.PRODUCT_ID);
		assertNotNull(productDetails);
		assertEquals(ProductDetailsTestUtility.PRODUCT_NAME, productDetails.getName());
	}
	
	@Test
	public void test_updateProductPrice() {
		RetailProduct updatedRetailProduct = productDetailsService.updateProductPrice(Integer.valueOf(ProductDetailsTestUtility.PRODUCT_ID),
				ProductDetailsTestUtility.createProductDetails(ProductDetailsTestUtility.PRODUCT_ID, ProductDetailsTestUtility.UPDATED_PRICE));
		assertNotNull(updatedRetailProduct);
		assertEquals(ProductDetailsTestUtility.UPDATED_PRICE, updatedRetailProduct.getPrice());
	}
	
	@Test(expected = RuntimeException.class)
	public void test_updateProductPrice_throwsException() {
		productDetailsService.updateProductPrice(Integer.valueOf(ProductDetailsTestUtility.PRODUCT_ID),
				ProductDetailsTestUtility.createProductDetails(ProductDetailsTestUtility.DIFFERING_PRODUCT_ID, ProductDetailsTestUtility.UPDATED_PRICE));
	}
	
	@Test(expected = RuntimeException.class)
	public void test_updateRetailProductPrice_throwsException() {
		productDetailsService.updateRetailProductPrice(ProductDetailsTestUtility.createProductDetails(
				ProductDetailsTestUtility.PRODUCT_ID, ProductDetailsTestUtility.PRICE), Optional.of(null));
	}
}
