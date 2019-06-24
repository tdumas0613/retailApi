package com.dumas.retail.api.product.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dumas.retail.api.pojos.ProductDetails;

@Controller
@RequestMapping(value="products")
public class ProductDetailsController {
	
	@Autowired
	private ProductDetailsService productDetailsService;
	
	@RequestMapping(value = "/details", params = {"id"}, method = RequestMethod.GET)
	public ProductDetails retrieveProductDetails(@RequestParam(value = "id") long id) {
		return productDetailsService.retrieveProductDetails(id);
	}
}
