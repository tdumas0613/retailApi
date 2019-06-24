package com.dumas.retail.api.product.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dumas.retail.api.client.RedSkyClient;
import com.dumas.retail.api.pojos.CurrentPrice;
import com.dumas.retail.api.pojos.ProductDetails;

@Service
public class ProductDetailsService {

	private static final double CURRENT_PRICE_VALUE = 13.49;
	private static final String CURRENT_PRICE_CURRENCY_CODE = "USD";
	
	@Autowired
	private RedSkyClient redSkyClient;

	public ProductDetails retrieveProductDetails(long id) {
		return createNewProductDetails(id);
	}

	private ProductDetails createNewProductDetails(long id) {
		ProductDetails productDetails = new ProductDetails();
		productDetails.setId(id);
		productDetails.setName(redSkyClient.retrieveProductName());
		productDetails.setCurrentPrice(createCurrentPrice(CURRENT_PRICE_VALUE, CURRENT_PRICE_CURRENCY_CODE));
		return productDetails;
	}

	protected CurrentPrice createCurrentPrice(double value, String currencyCode) {
		return new CurrentPrice(value, currencyCode);
	}
}
