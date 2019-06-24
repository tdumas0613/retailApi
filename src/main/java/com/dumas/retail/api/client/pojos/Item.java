package com.dumas.retail.api.client.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
	
	@JsonProperty("product_description")
	public ProductDescription productDescription;

	public ProductDescription getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(ProductDescription productDescription) {
		this.productDescription = productDescription;
	}
}
