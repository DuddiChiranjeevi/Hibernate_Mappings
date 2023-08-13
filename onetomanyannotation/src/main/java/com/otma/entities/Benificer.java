package com.otma.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "benificer")
@Data
public class Benificer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "benificer_id")
	private int benificarId;
	@Column(name = "full_nm")
	private String fullName;
	private LocalDate dob;
	private String gender;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "account_no")
	private String accountNo;
	@Column(name = "ifsc_code")
	private String ifscCode;
	@Column(name="aadhar_no")
	private long aadharNo;
//	@ManyToOne
//	@JoinColumn(name="scheme_id" ,nullable = false)
//	
//	private Scheme scheme;
//	
}
