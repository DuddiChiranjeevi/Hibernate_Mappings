package com.mtma.entities;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passenger")
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "passenger_no")
	private int passengerNo;
	@Column(name = "passenger_nm")
	private String passengerName;
	private LocalDate dob;
	private String gender;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "email_id")
	private String emailId;
	private String address;
	@ManyToMany(mappedBy ="passengers",cascade = CascadeType.ALL)
//	@JoinTable(name = "passenger_trip", joinColumns = { @JoinColumn(name = "passenger_no") }, inverseJoinColumns = {
//			@JoinColumn(name = "trip_id") })
	Set<Trip> tripDetails;
}
