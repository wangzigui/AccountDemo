package com.nf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController1 {
	
	@RequestMapping(value = "hello" , method = RequestMethod.GET)
	public String helloworld(@RequestParam(value="name", required=false, defaultValue="World!!") String name,Model model)
	{
		List<Product> productList = new ArrayList<Product>();
		Product Product = new Product("sdf","sdf","sdf","sdf");
		Product Producta = new Product("sdfd","sdfd","sdfd","sdfd");
		productList.add(Product);
		productList.add(Producta);
		model.addAttribute("hello",name);  
		model.addAttribute("productList", productList);
	    return"/helloHtml"; 
	}
	
	@RequestMapping(value = "hello1" , method = RequestMethod.GET)
	public String helloworld(Model model)
	{
		List<Product> productList = new ArrayList<Product>();
		Product Product = new Product("sdf","sdf","sdf","sdf");
		Product Producta = new Product("sdfd","sdfd","sdfd","sdfd");
		productList.add(Product);
		productList.add(Producta);

		model.addAttribute("productList", productList);
	    return"/hello"; 
	}
}
