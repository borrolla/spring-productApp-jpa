package com.productcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productcatalog.model.Product;
import com.productcatalog.model.ProductDTO;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {


}
