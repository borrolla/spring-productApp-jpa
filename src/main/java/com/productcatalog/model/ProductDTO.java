package com.productcatalog.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
	
	private Integer productId;
	private String productName;
	private String brand;
	private String category;
    private Double price;
}
