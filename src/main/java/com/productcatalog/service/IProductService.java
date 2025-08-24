package com.productcatalog.service;

import java.util.List;

import com.productcatalog.model.ProductDTO;

public interface IProductService {
	
	ProductDTO addProduct(ProductDTO productDto);
	ProductDTO updateProduct(ProductDTO productDto);
	ProductDTO getById(int productId);
	List<ProductDTO> getAll();


}
