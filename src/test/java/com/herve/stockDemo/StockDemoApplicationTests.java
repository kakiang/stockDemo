package com.herve.stockDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.herve.stockDemo.controller.ProduitController;
import com.herve.stockDemo.repository.ProduitRepository;

@SpringBootTest
class StockDemoApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(StockDemoApplicationTests.class);

	@Autowired
	private ProduitRepository produitRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void findAll(){
		log.info("... findAll ...");
		var produits = produitRepository.findAll();
		assertEquals(produits.size(), 1);
	}

}
