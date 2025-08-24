package com.productcatalog.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalog.model.Product;
import com.productcatalog.model.ProductDTO;
import com.productcatalog.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private IProductRepository repository;

	@Override
	public ProductDTO addProduct(ProductDTO productDto) {
		// TODO Auto-generated method stub

		// convert dto into entity and call repo for saving
		//Product product = mapper.map(productDto, Product.class);
		// use repo to save it
		// check if id is available
		// if not available generate it and save as new record
		// if available - check if record is there in db ->
		//				if yes update it ,  if no create a new record
		//repository.save(product);
		
		Product product = mapper.map(productDto, Product.class);
		Product savedProduct = repository.save(product);
		return mapper.map(savedProduct, ProductDTO.class);

	}

	
	public ProductDTO updateProduct(ProductDTO productDto){
		// TODO Auto-generated method stub
		// convert dto into entity and call repo for saving

		 if (productDto.getProductId() == null) {
		        throw new IllegalArgumentException("Product ID is required for update");
		    }

		    Optional<Product> optionalProduct = repository.findById(productDto.getProductId());
		    if (optionalProduct.isPresent()) {
		        Product existingProduct = optionalProduct.get();

		        // Update only necessary fields
		        existingProduct.setProductName(productDto.getProductName());
		        existingProduct.setBrand(productDto.getBrand());
		        existingProduct.setCategory(productDto.getCategory());
		        existingProduct.setPrice(productDto.getPrice());

		        Product savedProduct = repository.save(existingProduct);
		        return mapper.map(savedProduct, ProductDTO.class);
		    } else {
		        throw new RuntimeException("Product not found with ID: " + productDto.getProductId());
		    }	
    }

	
	@Override
	public ProductDTO getById(int productId) {
		return repository.findById(productId)
                .map(product -> mapper.map(product, ProductDTO.class)) // entity -> DTO
                .orElse(null);
	}

	@Override
	public List<ProductDTO> getAll() {
		// TODO Auto-generated method stub

		// FIX: repository.findAll() returns List<Product>, not List<ProductDTO>
		return repository.findAll().stream()
				.map(product -> mapper.map(product, ProductDTO.class))
				.toList();

	}
	
}


