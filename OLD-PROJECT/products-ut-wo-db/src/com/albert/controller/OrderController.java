package com.albert.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.albert.model.Order;
import com.albert.model.Product;

@Controller
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	//http://localhost:8080/products/rest/order/create
	@RequestMapping(value = ProductRestURIConstants.CREATE_ORDER, method = RequestMethod.POST)
	public @ResponseBody String createProduct(@RequestBody Order order) {
		logger.info("Start create order.");
		
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			//String jsonSting = mapper.writeValueAsString(product);
			System.out.println("create order jsonString:");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "12345678910";
	}
	
}
