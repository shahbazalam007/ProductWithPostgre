package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nt.entity.Product;
import com.nt.service.IProductService;

@RestController
@RequestMapping("/product_api")
public class ProductOperationController {
	@Autowired
	private IProductService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> saveTourist(@RequestBody Product product){
		//use service
				try {
				String msg = service.registerProduct(product);
				return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		    	}catch (Exception e) {
		    		throw e;
			    }
	          }
	
   @GetMapping("/getall")
	public ResponseEntity<?> getAllProduct(){
		try {
			List<Product> allProduct = service.fetchAllProduct();
			return new ResponseEntity<List<Product>>(allProduct,HttpStatus.OK);
		  }catch (Exception e) {
			  throw e;
			  
		  }
	   }
   
   @GetMapping("/find/{id}")
   public ResponseEntity<?> getTouristById(@PathVariable("id") int id){
	   try {
		   Product product = service.findProductById(id);
		   return new ResponseEntity<Product>(product,HttpStatus.OK);
	      }catch (Exception e) {
	    	  throw e;
	     }
       }
   
   
   @PutMapping("/modify")
   public ResponseEntity<?> modifyTourist(@RequestBody Product tourist){
	    try {
		   String details = service.updateProductDetails(tourist);
		   return new ResponseEntity<String>(details,HttpStatus.OK);
	    }catch (Exception e) {
	    	throw e;
	   }
    }
   
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> deleteProductById(@PathVariable("id")int id){
	    try {
			   String delete = service.removeProductById(id);
			   return new ResponseEntity<String>(delete,HttpStatus.OK);
		    }catch (Exception e) {
		    	throw e;
		   }
       }
   
   
      
   
}
