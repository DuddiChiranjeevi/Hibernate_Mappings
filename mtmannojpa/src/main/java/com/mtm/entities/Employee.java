package com.mtm.entities;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "of")
@ToString(exclude = {"projects"})
@EqualsAndHashCode(exclude = {"projects","dob"})
@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private int empId;
	@Column(name="emp_nm")
	private String empName;
	private LocalDate dob;
	private String gender;
	@Column(name="email_id")
	private String emailId;
	@Column(name="mobile_no")
	private String mobileNo;
	private String designation;
	@ManyToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	private Set<Project> projects;
	

}
