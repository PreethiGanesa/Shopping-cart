package com.pree.shoppingcart.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan(basePackages = "com")
@Configuration
public class ClassConfig {
	
	@Bean
	public InternalResourceViewResolver reslover()
	{
		InternalResourceViewResolver reslover =new InternalResourceViewResolver();
		reslover.setSuffix(".jsp");
		reslover.setPrefix("/");
		
		return reslover;
	}
	
	
	@Bean
	public EntityManagerFactory getemf()
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		
		return emf;
	}

}
