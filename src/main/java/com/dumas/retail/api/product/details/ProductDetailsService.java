package com.dumas.retail.api.product.details;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	public ProductDetails retrieveProductDetails(String id) {
		ProductDetails productDetails = new ProductDetails();
		productDetails.setId(id);
		productDetails.setName(redSkyClient.retrieveProductName());
		
		Optional<RetailProduct> retailProduct = retailProductRepository.findById("123");
		boolean isRetailProductPresent = retailProduct.isPresent();
		
		CurrentPrice currentPrice = new CurrentPrice();
		currentPrice.setValue(isRetailProductPresent ? retailProduct.get().getPrice() : 0.01);
		currentPrice.setCurrencyCode(isRetailProductPresent ? retailProduct.get().getCurrencyCode() : "CAD");
		
		productDetails.setCurrentPrice(currentPrice);
		return productDetails;
	}
}
