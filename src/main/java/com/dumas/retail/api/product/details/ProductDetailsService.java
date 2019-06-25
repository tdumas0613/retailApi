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
	
	public RetailProduct updateProductPrice(Integer productId, ProductDetails productDetails) {
		Integer productDetailsId = Integer.valueOf(productDetails.getId());
		if(productId.equals(productDetailsId)) {
			Optional<RetailProduct> optionalMatchingRetailProduct = retailProductRepository.findByProductId(productDetailsId);
			return updateRetailProductPrice(productDetails, optionalMatchingRetailProduct);
		} else {
			throw new RuntimeException("Error - URI Product id does not match Request Body Product id. "
					+ "Please adjust your inputs and try again.");
		}
	}

	private RetailProduct updateRetailProductPrice(ProductDetails productDetails,
			Optional<RetailProduct> optionalMatchingRetailProduct) {
		if(optionalMatchingRetailProduct.isPresent()) {
			RetailProduct matchingRetailProduct = optionalMatchingRetailProduct.get();
			matchingRetailProduct.setPrice(productDetails.getCurrentPrice().getValue());
			return retailProductRepository.save(matchingRetailProduct);
		} else {
			throw new RuntimeException("Failed to retrieve matching product from database");
		}
	}

	public ProductDetails retrieveProductDetails(String productId) {
		ProductDetails productDetails = new ProductDetails();
		productDetails.setId(productId);
		productDetails.setName(redSkyClient.retrieveProductName());
		productDetails.setCurrentPrice(establishCurrentPrice(Integer.valueOf(productId)));
		return productDetails;
	}
	
	protected CurrentPrice establishCurrentPrice(Integer productId) {
		Optional<RetailProduct> retailProduct = retailProductRepository.findByProductId(productId);
		boolean isRetailProductPresent = retailProduct.isPresent();
		CurrentPrice currentPrice = new CurrentPrice();
		currentPrice.setValue(isRetailProductPresent ? retailProduct.get().getPrice() : null);
		currentPrice.setCurrencyCode(isRetailProductPresent ? retailProduct.get().getCurrencyCode() : null);
		return currentPrice;
	}
}