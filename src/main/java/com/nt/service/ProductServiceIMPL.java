package com.nt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nt.entity.Product;
import com.nt.error.ProductNotFoundException;
import com.nt.repository.IProductRepository;


import lombok.NonNull;
@Service
public class ProductServiceIMPL implements IProductService {

	@Autowired
	private IProductRepository repo;
	
	@Override
	public String registerProduct(Product product) {
		Integer pid = repo.save(product).getPid();
		return "Product is saved with ID value : "+pid;
	}

	@Override
	public List<Product> fetchAllProduct() {
		List<Product> allList = repo.findAll();
	    allList.sort((t1,t2)->t1.getPid().compareTo(t2.getPid()));
		return allList;
	}

	@Override
	public Product findProductById(int id) throws ProductNotFoundException {
		Product tourist = repo.findById(id).orElseThrow(()->new ProductNotFoundException("Product who's id is: "+id+" not avalible"));
		return tourist;
	}


	@Override
	public String updateProductDetails(Product product) throws ProductNotFoundException {
		//get the product by id
		 Optional <Product> prod=repo.findById(product.getPid());
		 if(prod.isPresent()) {
			repo.save(product);
			return "Product is Updated with new Details";
		}
		else 
		 throw new ProductNotFoundException(product.getPid()+": id Product is not avalible for updation");
		}


	@Override
	public String removeProductById(int id) throws ProductNotFoundException {
		Optional <Product> opt=repo.findById(id);
		if(opt.isPresent()) {
			repo.deleteById(id);;
			return "Product is found and deleted who's id is: "+id;
		}
		else
			 throw new ProductNotFoundException(id+": id Product is not avalible for updation");
	}


}
