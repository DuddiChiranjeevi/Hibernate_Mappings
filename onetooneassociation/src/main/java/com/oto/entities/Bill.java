package com.oto.entities;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
@Data
public class Bill implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int billNo;
	private String billName;
	private LocalDate billGenratedDate;
	private String customerName;
	private String mobileNo;
	private LocalDate dueDate;
	private String billAmount;
	
	
}
