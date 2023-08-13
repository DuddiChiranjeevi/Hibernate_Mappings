package com.otml.entities;

import java.util.List;

import org.hibernate.annotations.ListIndexBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "of")
@Entity
@Table(name = "restaurant")
@EqualsAndHashCode(exclude = { "orders", "rating" })
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private int restaurantId;
	@Column(name = "restaurant_nm")
	private String restaurantName;
	private String address;
	@Column(name = "contact_no")
	private String contactNo;
	@Column(name = "email_id")
	private String emailId;
	private int rating;
	@OneToMany
	@JoinColumn(name = "restaurant_id")
	@OrderColumn(name = "resturant_index")
	@ListIndexBase(value = 1)
	private List<Order> orders;

}
