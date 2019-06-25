package com.dumas.retail.api.product.details;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dumas.retail.api.client.RedSkyClient;
import com.dumas.retail.api.domain.RetailProduct;
import com.dumas.retail.api.domain.RetailProductRepository;
import com.dumas.retail.api.pojos.CurrentPrice;
import com.dumas.retail.api.pojos.ProductDetails;

@Service
public class ProductDetailsService {
	
	@Autowired
	private RedSkyClient redSkyClient;
	
	@Autowired
	private RetailProductRepository retailProductRepository;

	public ProductDetails retrieveProductDetails(String productId) {
		ProductDetails productDetails = new ProductDetails();
		productDetails.setId(productId);
		productDetails.setName(redSkyClient.retrieveProductName());
		productDetails.setCurrentPrice(establishCurrentPrice(productId));
		return productDetails;
	}
	
	protected CurrentPrice establishCurrentPrice(String productId) {
		
		Optional<RetailProduct> retailProduct = retailProductRepository.findByProductId("123");
		boolean isRetailProductPresent = retailProduct.isPresent();
		
		CurrentPrice currentPrice = new CurrentPrice();
		Double price = isRetailProductPresent ? retailProduct.get().getPrice() : null;
		String currencyCode = isRetailProductPresent ? retailProduct.get().getCurrencyCode() : null;
		currentPrice.setValue(price);
		currentPrice.setCurrencyCode(currencyCode);
		return currentPrice;
	}
}
