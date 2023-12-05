package com.nt.service;

import java.util.List;

import com.nt.entity.Product;
import com.nt.error.ProductNotFoundException;


public interface IProductService {
	public String registerProduct(Product product);
	public List<Product> fetchAllProduct();
	public Product findProductById(int id)throws ProductNotFoundException;
	public String updateProductDetails(Product tourist)throws ProductNotFoundException;
	public String removeProductById(int id)throws ProductNotFoundException;

}
