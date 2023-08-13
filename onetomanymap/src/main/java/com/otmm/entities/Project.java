package com.otmm.entities;

import java.io.Serializable;

import lombok.Data;
@Data
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	private int projectId;
	private String projectName;
	private String description;
	private int duration ;
	private double estimatedAmount;
	
	
	
	
}
