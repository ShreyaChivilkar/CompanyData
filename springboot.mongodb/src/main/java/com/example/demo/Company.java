package com.example.demo;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NewCollection")
public class Company {
	
	
	@Id
	private String id;
	private String name;
	
	@Indexed(direction = IndexDirection.ASCENDING)
	private int stock;
	
	private Address address;
	private List<Review>reviews;
	
	protected Company()
	{
		this.reviews = new ArrayList<>();
	}
	
	public Company(String name, int stock, Address address,List<Review>reviews) {
		this.name = name;
		this.stock = stock;
		this.address = address;
		this.reviews = reviews;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getStock() {
		return stock;
	}


	public Address getAddress() {
		return address;
	}

	public List<Review> getReviews() {
		return reviews;
	}


}
