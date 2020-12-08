package com.albert.controller;

public class ProductRestURIConstants {

	public static final String DUMMY_PRODUCT = "/rest/product/dummy";
	public static final String GET_PRODUCT = "/rest/product/{id}";
	public static final String GET_PRODUCT_DESCRIPTION_ENGLISH = "/rest/product/productDescriptionEnglish/{productDescriptionEnglish}";
	public static final String GET_PRODUCT_ID_AND_PRODUCT_DESCRIPTION_ENGLISH = "/rest/product/{productId}/productIdAndProductDescriptionEnglish/{productDescriptionEnglish}";
	public static final String GET_ALL_PRODUCTS = "/rest/products";
	public static final String GET_AVAILABLE_PRODUCTS = "/rest/availableProducts";
	public static final String CREATE_PRODUCT = "/rest/product/create";
	public static final String DELETE_PRODUCT = "/rest/product/delete/{id}";
	
	
	public static final String CREATE_ORDER = "/rest/order/create";
}
