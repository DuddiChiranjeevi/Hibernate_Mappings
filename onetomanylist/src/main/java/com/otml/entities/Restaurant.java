package com.otml.entities;

import java.util.List;

import lombok.Data;

@Data
public class Restaurant {

	private int restaurantId;
	private String restaurantName;
	private String address;
	private String contactNo;
	private String emailId;
	private int rating;
	private List<Order> orders;
	
}
