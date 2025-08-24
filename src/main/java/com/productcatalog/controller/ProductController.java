package com.productcatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalog.model.ProductDTO;
import com.productcatalog.service.IProductService;

@Controller
@RestController
public class ProductController {
	
	@Autowired
	private IProductService productService;
	


//	http://localhost:8080/products
	@PostMapping("/products")
	//data comes in body part of the request - use @RequestBody
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDto) {
		ProductDTO savedProduct = productService.addProduct(productDto);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	
	//data comes in body part of the request - use @RequestBody
		// id should come in the request- only then record will be updated
	@PutMapping("/products")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDto) {
		ProductDTO updateProduct = productService.updateProduct(productDto);
		return new ResponseEntity<>(updateProduct, HttpStatus.OK);
		
	}
	
//	http://localhost:8080/products/productId/1
	@GetMapping("/products/productId/{productID}")
	ProductDTO getById(@PathVariable Integer productID) {
		return productService.getById(productID);
	}
	
	//http://localhost:8080/products
	@GetMapping("/products")
	Iterable<ProductDTO> getAll(){
		return productService.getAll();
	}
}





