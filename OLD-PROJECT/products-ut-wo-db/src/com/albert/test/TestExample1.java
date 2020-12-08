package com.albert.test;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.albert.controller.ProductRestURIConstants;
import com.albert.model.Product;
import com.albert.model.ProductAvailability;

import static org.junit.Assert.*;
public class TestExample1 
{
	public static final String SERVER_URI = "http://localhost:8080/products-ut-wo-db";
	

	//http://localhost:8080/products-ut-wo-db/rest/availableProducts
	@Test
	public void testGetProductAvailability() {
		RestTemplate restTemplate = new RestTemplate();
		ProductAvailability productAvailability = restTemplate.getForObject(SERVER_URI+"/rest/availableProducts", ProductAvailability.class);
		assertNotNull(productAvailability);
	}
	
	//http://localhost:8080/products-ut-wo-db/rest/product/creates
	//create new employee, method = RequestMethod.POST
	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		
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
			String jsonInString = mapper.writeValueAsString(product1);
			System.out.println("jsonInString:"+jsonInString);
			Product response = restTemplate.postForObject(SERVER_URI+ProductRestURIConstants.CREATE_PRODUCT, product1, Product.class);
			assertNotNull(response);
			printProductData(response);
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
	}
	
	public static void printProductData(Product product){
		System.out.println("ID="+product.getId()+",ProductDescriptionEnglish="+product.getProductDescriptionEnglish()+
				",ProductDescriptionFrench:"+product.getProductDescriptionFrench()+
				",BrandNameEnglish:"+product.getBrandNameEnglish());
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(product);
			System.out.println("jsonString:"+jsonString);
		}
		catch(Exception e)
		{
			System.out.println("jsonString:"+e.getMessage());
		}
	}
	
	//http://localhost:8080/products-ut-wo-db/rest/product/1
	//Get product with productId 1, method = RequestMethod.GET
		@Test
		public  void testGetProduct() {
			RestTemplate restTemplate = new RestTemplate();
			Product product = restTemplate.getForObject(SERVER_URI+"/rest/product/1", Product.class);
			printProductData(product);
			assertNotNull(product);
	}
	
    //http://localhost:8080/products-ut-wo-db/rest/product/productDescriptionEnglish/CHICKEN%20NOODLE%20SOUP       	
	@Test
	public  void testGetProductDescriptionEnglish() {
         
	  
	   RestTemplate restTemplate = new RestTemplate();
	   List<LinkedHashMap> products = restTemplate.getForObject(SERVER_URI+"/rest/product/productDescriptionEnglish/CHICKEN%20NOODLE%20SOUP", List.class);
	   System.out.println("number of records:"+products.size());
		for(LinkedHashMap map : products){
			System.out.println("ID="+map.get("id")+",productDescriptionEnglish="
					+map.get("productDescriptionEnglish")
					+",productDescriptionFrench="+map.get("productDescriptionFrench")
					+",brandNameEnglish="+map.get("brandNameEnglish")
					+",brandNameFrench="+map.get("brandNameFrench")
					+",productType="+map.get("productType")
					+",additionalProductIdentification="+map.get("additionalProductIdentification")
					+",targetMarket="+map.get("targetMarket")
					+",productImageUrl="+map.get("productImageUrl")
					+",status="+map.get("status"));
			//printProductData(map);
		}
	   assertNotNull(products);
	}
		
	@Test
	public  void testGetProductIdAndProductDescriptionEnglish() {
			//http://localhost:8080/products-ut-wo-db/rest/product/1/productIdAndProductDescriptionEnglish/CHICKEN%20NOODLE%20SOUP

			RestTemplate restTemplate = new RestTemplate();
			Product product = restTemplate.getForObject(SERVER_URI+"/rest/product/1/productIdAndProductDescriptionEnglish/CHICKEN%20NOODLE%20SOUP", Product.class);
			printProductData(product);
			assertNotNull(product);
	}
	
	

	
	
	//http://localhost:8080/products-ut-wo-db/rest/products
	//Get all productss,  method = RequestMethod.GET
	@Test
	public void testGetAllProduct() {
			RestTemplate restTemplate = new RestTemplate();
			//we can't get List<Product> because JSON convertor doesn't know the type of
			//object in the list and hence convert it to default JSON object type LinkedHashMap
			List<LinkedHashMap> products = restTemplate.getForObject(SERVER_URI+ProductRestURIConstants.GET_ALL_PRODUCTS, List.class);
			System.out.println("number of records:"+products.size());
			for(LinkedHashMap map : products){
				System.out.println("ID="+map.get("id")+",productDescriptionEnglish="
						+map.get("productDescriptionEnglish")
						+",productDescriptionFrench="+map.get("productDescriptionFrench")
						+",brandNameEnglish="+map.get("brandNameEnglish")
						+",brandNameFrench="+map.get("brandNameFrench")
						+",productType="+map.get("productType")
						+",additionalProductIdentification="+map.get("additionalProductIdentification")
						+",targetMarket="+map.get("targetMarket")
						+",productImageUrl="+map.get("productImageUrl")
						+",status="+map.get("status"));
				//printProductData(map);
			}
		}
}
