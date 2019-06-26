package com.dumas.retail.api.product.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dumas.retail.api.domain.RetailProduct;
import com.dumas.retail.api.pojos.ProductDetails;

@RestController
@RequestMapping(value="products")
public class ProductDetailsController {
	
	@Autowired
	private ProductDetailsService productDetailsService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ProductDetails retrieveProductDetails(@PathVariable(value = "id") String productId) {
		return productDetailsService.retrieveProductDetails(productId);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public RetailProduct updateProductPrice(@PathVariable(value = "id")  String productId, @RequestBody ProductDetails productDetails) {
		return productDetailsService.updateProductPrice(Integer.valueOf(productId), productDetails);
	}
}