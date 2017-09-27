package com.nf.controller;

public class Product {
	private String count;
	private String description;
	private String price;
	private String availableFrom;
	
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(String availableFrom) {
		this.availableFrom = availableFrom;
	}

	public Product(String count, String description, String price, String availableFrom) {
		super();
		this.count = count;
		this.description = description;
		this.price = price;
		this.availableFrom = availableFrom;
	}
	
}	
