package com.dumas.retail.api.product.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dumas.retail.api.pojos.ProductDetails;

@RestController
@RequestMapping(value="products")
public class ProductDetailsController {
	
	@Autowired
	private ProductDetailsService productDetailsService;
	
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ProductDetails retrieveProductDetails(@RequestParam(value = "id") String productId) {
		return productDetailsService.retrieveProductDetails(productId);
	}
}
