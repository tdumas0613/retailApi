package com.dumas.retail.api.clients;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dumas.retail.api.ApplicationTests;
import com.dumas.retail.api.client.RedSkyClient;

@RunWith(SpringJUnit4ClassRunner.class)
public class RedSkyClientIT extends ApplicationTests {
	
	private static final String PRODUCT_NAME = "The Big Lebowski (Blu-ray)";
	
	@Autowired
	private RedSkyClient redSkyClient;
	
	@Test
	public void test_retrieveProductName() {
		String productName = redSkyClient.retrieveProductName();
		assertEquals(PRODUCT_NAME, productName);
	}
}
