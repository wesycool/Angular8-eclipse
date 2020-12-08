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
import com.albert.model.Product;
import com.albert.model.ProductAvailability;


/**
 * Handles requests for the Employee service.
 */
@Controller
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	//Map to store employees, ideally we should use database
	Map<Integer, Product> productData = new HashMap<Integer, Product>();
	
	//http://localhost:8080/products-ut-wo-db/rest/emp/dummy
	///rest/emp/dummy";
	@RequestMapping(value = ProductRestURIConstants.DUMMY_PRODUCT, method = RequestMethod.GET)
	public @ResponseBody Product getDummyProduct() {
		logger.info("Start getDummyEmployee");
		Product product = new Product();
		product.setId(9999);
		product.setProductDescriptionEnglish("Chicken Noodle Soup");
		product.setProductDescriptionFrench("French Chicken Noodle Soup");
		product.setBrandNameEnglish("Campbell Chicken Noodle Soup");
		product.setBrandNameFrench("French Campbell Chicken Noodle Soup");
		product.setProductType("Pallet");  //DROP-DOWN->Pallet, Case, Consumer or Base
		product.setAdditionalProductIdentification("It is a soup");
		product.setTargetMarket("Canada"); //DROP-DOWN ->Canada, US
		product.setProductImageUrl("http://campbellSoup");
		product.setStatus("Active"); //DROP-DOWN->Active, Draft
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			String jsonSting = mapper.writeValueAsString(product);
			System.out.println("dummy product jsonString:"+jsonSting);
		}
		catch(JsonGenerationException e)
		{
			e.printStackTrace();
		}
		catch(JsonMappingException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		productData.put(9999, product);
		return product;
	}
	
	//http://localhost:8080/products-ut-wo-db/rest/product/1
	///rest/emp/{id}
	@RequestMapping(value = ProductRestURIConstants.GET_PRODUCT, method = RequestMethod.GET)
	public @ResponseBody Product getProduct(@PathVariable("id") int productId) {
		logger.info("Start getEmployee. ID="+productId);
		
		try
		{
			Product product = new Product();
			product.setId(1);
			product.setProductDescriptionEnglish("Chicken Noodle Soup");
			product.setProductDescriptionFrench("French Chicken Noodle Soup");
			product.setBrandNameEnglish("Campbell Chicken Noodle Soup");
			product.setBrandNameFrench("French Campbell Chicken Noodle Soup");
			product.setProductType("Pallet");  //DROP-DOWN->Pallet, Case, Consumer or Base
			product.setAdditionalProductIdentification("It is a soup");
			product.setTargetMarket("Canada"); //DROP-DOWN ->Canada, US
			product.setProductImageUrl("http://campbellSoup");
			product.setStatus("Active"); //DROP-DOWN->Active, Draft
			
			
			productData.put(1, product);
			ObjectMapper mapper = new ObjectMapper();
			String jsonSting = mapper.writeValueAsString(productData.get(productId));
			System.out.println("get a particular product jsonString:"+jsonSting);
		}
		catch(JsonGenerationException e)
		{
			e.printStackTrace();
		}
		catch(JsonMappingException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return productData.get(productId);
	}
	
	//http://localhost:8080/products-ut-wo-db/rest/product/productDescriptionEnglish/CHICKEN%20NOODLE%20SOUP
	@RequestMapping(value = ProductRestURIConstants.GET_PRODUCT_DESCRIPTION_ENGLISH, method = RequestMethod.GET)
	public @ResponseBody List<Product> getProductDescriptionEnglish(@PathVariable("productDescriptionEnglish") String productDescriptionEnglish) {
		logger.info("Start getProductDescriptionEnglish="+productDescriptionEnglish);
		Product product1 = new Product();
		product1.setId(1);
		product1.setProductDescriptionEnglish("Chicken Noodle Soup");
		product1.setProductDescriptionFrench("French Chicken Noodle Soup");
		product1.setBrandNameEnglish("Campbell Chicken Noodle Soup");
		product1.setBrandNameFrench("French Campbell Chicken Noodle Soup");
		product1.setProductType("Consumer or Base");  //DROP-DOWN->Pallet, Case, Consumer or Base
		product1.setAdditionalProductIdentification("It is a soup");
		product1.setTargetMarket("Canada"); //DROP-DOWN ->Canada, US
		product1.setProductImageUrl("http://wwww.campbellSoup.com");
		product1.setStatus("Active"); //DROP-DOWN->Active, Draft
		productData.put(1, product1);
		
		Product product2 = new Product();
		
		product2.setId(2);
		product2.setProductDescriptionEnglish("Chocolate Chip Cookie");
		product2.setProductDescriptionFrench("French Chocolate Chip Cookie");
		product2.setBrandNameEnglish("Mrs. Fields");
		product2.setBrandNameFrench("French Mrs. Fields");
		product2.setProductType("Consumer or Base");  //DROP-DOWN->Pallet, Case, Consumer or Base
		product2.setAdditionalProductIdentification("It is a cookie");
		product2.setTargetMarket("Canada"); //DROP-DOWN ->Canada, US
		product2.setProductImageUrl("http://www.mrsfields.com");
		product2.setStatus("Active"); //DROP-DOWN->Active, Draft
		productData.put(2, product2);
		
		
		Product product3 = new Product();
		
		product3.setId(3);
		product3.setProductDescriptionEnglish("Potato Chips");
		product3.setProductDescriptionFrench("French Potato Chips");
		product3.setBrandNameEnglish("Lays");
		product3.setBrandNameFrench("French Lays");
		product3.setProductType("Consumer or Base");  //DROP-DOWN->Pallet, Case, Consumer or Base
		product3.setAdditionalProductIdentification("It is a potato chip");
		product3.setTargetMarket("Canada"); //DROP-DOWN ->Canada, US
		product3.setProductImageUrl("http://www.lays.com");
		product3.setStatus("Active"); //DROP-DOWN->Active, Draft
		
		
		productData.put(3, product3);
		
		
		List<Product> products = new ArrayList<Product>();
		Set<Integer> empIdKeys = productData.keySet();
		for(Integer i : empIdKeys){
			products.add(productData.get(i));
		}
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			String jsonSting = mapper.writeValueAsString(products);
			System.out.println("get list of products jsonString:"+jsonSting);
		}
		catch(JsonGenerationException e)
		{
			e.printStackTrace();
		}
		catch(JsonMappingException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return products;
	}
	
	
	//http://localhost:8080/products-ut-wo-db/rest/product/1/productIdAndProductDescriptionEnglish/CHICKEN%20NOODLE%20SOUP
	@RequestMapping(value = ProductRestURIConstants.GET_PRODUCT_ID_AND_PRODUCT_DESCRIPTION_ENGLISH, method = RequestMethod.GET)
//	@RequestMapping(value = ProductRestURIConstants.GET_PRODUCT_ID_AND_PRODUCT_DESCRIPTION_ENGLISH, method = RequestMethod.POST)
	public @ResponseBody Product getProductIdAndProductDescriptionEnglish(@PathVariable("productId") int productId,@PathVariable("productDescriptionEnglish") String productDescriptionEnglish) {
		logger.info("Start productId="+productId);
		logger.info("Start getProductDescriptionEnglish="+productDescriptionEnglish);
		Product product = new Product();
			
		try
		{
			product.setId(1);
			product.setProductDescriptionEnglish("Chicken Noodle Soup");
			product.setProductDescriptionFrench("French Chicken Noodle Soup");
			product.setBrandNameEnglish("Campbell Chicken Noodle Soup");
			product.setBrandNameFrench("French Campbell Chicken Noodle Soup");
			product.setProductType("Pallet");  //DROP-DOWN->Pallet, Case, Consumer or Base
			product.setAdditionalProductIdentification("It is a soup");
			product.setTargetMarket("Canada"); //DROP-DOWN ->Canada, US
			product.setProductImageUrl("http://campbellSoup");
			product.setStatus("Active"); //DROP-DOWN->Active, Draft
			
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonSting = mapper.writeValueAsString(product);
			System.out.println("get a particular product jsonString:"+jsonSting);
		}
		catch(JsonGenerationException e)
		{
			e.printStackTrace();
		}
		catch(JsonMappingException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return product;
	}
	
	
	//http://localhost:8080/products-ut-wo-db/rest/availableProducts
	@RequestMapping(value = ProductRestURIConstants.GET_AVAILABLE_PRODUCTS , method = RequestMethod.GET)
	public @ResponseBody ProductAvailability getAvailableProducts() {
		
		ProductAvailability productAvailability = new ProductAvailability();
		productAvailability.setAvailableProducts(new Integer(54));
		productAvailability.setUnusedProducts(new Integer(170));
		return productAvailability;
	}
	
	
	//http://localhost:8080/products-ut-wo-db/rest/products
	@RequestMapping(value = ProductRestURIConstants.GET_ALL_PRODUCTS, method = RequestMethod.GET)
	public @ResponseBody List<Product> getAllProducts() {
		logger.info("Start getAllProducts."); 
		
		Product product1 = new Product();
		product1.setId(1);
		product1.setProductDescriptionEnglish("Chicken Noodle Soup");
		product1.setProductDescriptionFrench("French Chicken Noodle Soup");
		product1.setBrandNameEnglish("Campbell Chicken Noodle Soup");
		product1.setBrandNameFrench("French Campbell Chicken Noodle Soup");
		product1.setProductType("Consumer or Base");  //DROP-DOWN->Pallet, Case, Consumer or Base
		product1.setAdditionalProductIdentification("It is a soup");
		product1.setTargetMarket("Canada"); //DROP-DOWN ->Canada, US
		product1.setProductImageUrl("http://wwww.campbellSoup.com");
		product1.setStatus("Active"); //DROP-DOWN->Active, Draft
		productData.put(1, product1);
		
		Product product2 = new Product();
		
		product2.setId(2);
		product2.setProductDescriptionEnglish("Chocolate Chip Cookie");
		product2.setProductDescriptionFrench("French Chocolate Chip Cookie");
		product2.setBrandNameEnglish("Mrs. Fields");
		product2.setBrandNameFrench("French Mrs. Fields");
		product2.setProductType("Consumer or Base");  //DROP-DOWN->Pallet, Case, Consumer or Base
		product2.setAdditionalProductIdentification("It is a cookie");
		product2.setTargetMarket("Canada"); //DROP-DOWN ->Canada, US
		product2.setProductImageUrl("http://www.mrsfields.com");
		product2.setStatus("Active"); //DROP-DOWN->Active, Draft
		productData.put(2, product2);
		
		
		Product product3 = new Product();
		
		product3.setId(3);
		product3.setProductDescriptionEnglish("Potato Chips");
		product3.setProductDescriptionFrench("French Potato Chips");
		product3.setBrandNameEnglish("Lays");
		product3.setBrandNameFrench("French Lays");
		product3.setProductType("Consumer or Base");  //DROP-DOWN->Pallet, Case, Consumer or Base
		product3.setAdditionalProductIdentification("It is a potato chip");
		product3.setTargetMarket("Canada"); //DROP-DOWN ->Canada, US
		product3.setProductImageUrl("http://www.lays.com");
		product3.setStatus("Active"); //DROP-DOWN->Active, Draft
		
		
		productData.put(3, product3);
		
		
		List<Product> products = new ArrayList<Product>();
		Set<Integer> empIdKeys = productData.keySet();
		for(Integer i : empIdKeys){
			products.add(productData.get(i));
		}
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			String jsonSting = mapper.writeValueAsString(products);
			System.out.println("get list of products jsonString:"+jsonSting);
		}
		catch(JsonGenerationException e)
		{
			e.printStackTrace();
		}
		catch(JsonMappingException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return products;
	}
	
	//http://localhost:8080/products-ut-wo-db/rest/emp/create
	//rest/emp/create
	@RequestMapping(value = ProductRestURIConstants.CREATE_PRODUCT, method = RequestMethod.POST)
	public @ResponseBody Product createProduct(@RequestBody Product product) {
		logger.info("Start create product.");
		
		Product product1 = new Product();
		product1.setId(1);
		product1.setProductDescriptionEnglish("Chicken Noodle Soup");
		product1.setProductDescriptionFrench("French Chicken Noodle Soup");
		product1.setBrandNameEnglish("Campbell Chicken Noodle Soup");
		product1.setBrandNameFrench("French Campbell Chicken Noodle Soup");
		product1.setProductType("Consumer or Base");  //DROP-DOWN->Pallet, Case, Consumer or Base
		product1.setAdditionalProductIdentification("It is a soup");
		product1.setTargetMarket("Canada"); //DROP-DOWN ->Canada, US
		product1.setProductImageUrl("http://wwww.campbellSoup.com");
		product1.setStatus("Active"); //DROP-DOWN->Active, Draft
		
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			String jsonSting = mapper.writeValueAsString(product1);
			System.out.println("create product jsonString:"+jsonSting);
			
		}
		catch(JsonGenerationException e)
		{
			e.printStackTrace();
		}
		catch(JsonMappingException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return product1;
	}
	
	
	
	
}
