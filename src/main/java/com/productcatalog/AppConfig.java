package com.productcatalog;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	//create bean for modelmapper
	@Bean
	 ModelMapper modelMapper() {
		return new ModelMapper();
	}
	

}
