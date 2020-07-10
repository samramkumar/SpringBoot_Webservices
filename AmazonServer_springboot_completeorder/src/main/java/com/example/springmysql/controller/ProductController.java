package com.example.springmysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmysql.dao.ProductDao;
import com.example.springmysql.model.products;

@RestController
@RequestMapping("/product")
public class ProductController<dao> {
	@Autowired
	private ProductDao dao;
	
	
	@PostMapping("/completetheorder")
	public String bookTicket(@RequestBody List<products> products){
		dao.saveAll(products);
		return "number of products added :"+products.size();
	}
}
