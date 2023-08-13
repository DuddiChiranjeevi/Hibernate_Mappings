package com.otma.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student")
@Setter
@Getter
@ToString
@EqualsAndHashCode(exclude = {"dob","courses"})
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private int studentId;
	@Column(name="student_nm")
	private String studentName;
	private String gender;
	private LocalDate dob;
	@Column(name="email_id")
	private String emailId;
	@Column(name="mobile_no")
	private String mobileNo;
	@ManyToOne
	@JoinColumn(name="course_id" ,nullable = true)
	private Course courses;
}
