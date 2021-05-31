package com.product.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.product.model.*;
import com.product.service.*;


public interface IProductService {


	public static final Logger log = Logger.getLogger(IProductService.class.getName());


	public void addProduct(Product product);


	public Product getProductByID(String productID);
	

	public ArrayList<Product> getProducts();
	
	public Product updateProduct(String productID, Product product);

	public void removeProduct(String productID);

}
