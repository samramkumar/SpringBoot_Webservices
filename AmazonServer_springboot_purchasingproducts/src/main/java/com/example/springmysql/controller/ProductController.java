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
	
	
	@PostMapping("/addProducts")
	public String bookTicket(@RequestBody List<products> products){
		dao.saveAll(products);
		return "number of products added :"+products.size();
	}
	@GetMapping("/getProducts")
	public List<products> getProducts(){
		return (List<products>) dao.findAll();
	}
	@GetMapping("/getProducts/productname/{name}")
	public List<products> getProductsbyType(@PathVariable("name") String productname){
		return dao.findbyproductname(productname);
	}
	@GetMapping("/getProducts/productid/{type}")
	public List<products> getProductsbyType1(@PathVariable("type") String productid){
		return dao.findbyproductid(productid);
	}
}
