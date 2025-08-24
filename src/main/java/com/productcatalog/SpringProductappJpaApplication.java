package com.productcatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productcatalog.model.ProductDTO;
import com.productcatalog.service.IProductService;

@SpringBootApplication
public class SpringProductappJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappJpaApplication.class, args);
	}

	@Autowired
	private IProductService productService;

	@Override
	public void run(String... args) throws Exception {
		//create product
		//create a productdto object
		ProductDTO productDto = new ProductDTO( null,"Mobile","Samsung","Electronics", 20000.0);
		//call add product method
       productService.addProduct(productDto);
		
       // Get all products
       productService.getAll().forEach(System.out::println);

       // Optionally get by ID (use the correct ID if you know it)
       ProductDTO nproductDto = productService.getById(1); 
       System.out.println("Fetched Product by ID: " + nproductDto);
		   
	}

}
