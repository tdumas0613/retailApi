package com.dumas.retail.api.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RedSkyClient {
	
	private static final String RED_SKY_PRODUCT_URL = "https://redsky.target.com/"
			+ "v2/pdp/tcin/13860428?"
			+ "excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
	
	public String retrieveProductName() {
		RestTemplate restTemplate = new RestTemplate();
		RedSkyProduct redSkyProduct = restTemplate.getForEntity(RED_SKY_PRODUCT_URL, RedSkyProduct.class).getBody();
		return redSkyProduct.getProduct().getItem().getProductDescription().getTitle();
	}
}
