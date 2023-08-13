package com.otmm.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

import lombok.Data;
@Data
public class Vendor implements Serializable {
	private static final long serialVersionUID = 1L;
	private int vendorId;
	private String vendorName;
	private LocalDate estabelishedDate;
	private String mobileNo;
	private String emailId;
	Map<String , Project> allocatedProjects;
}
