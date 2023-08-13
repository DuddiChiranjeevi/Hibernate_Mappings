package com.otma.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Student {

	 private int studentId;
	 private String fullName;
	 private LocalDate age;
	 private String gender;
	 private String mobileNo;
	 private String emailId;
	// private Course course;
//	public Course getCourse() {
//		return course;
//	}
//	public void setCourse(Course course) {
//		this.course = course;
//	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public LocalDate getAge() {
		return age;
	}
	public void setAge(LocalDate age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", fullName=" + fullName + ", age=" + age + ", gender=" + gender
				+ ", mobileNo=" + mobileNo + ", emailId=" + emailId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, emailId, fullName, gender, mobileNo, studentId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(age, other.age) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(fullName, other.fullName) && Objects.equals(gender, other.gender)
				&& Objects.equals(mobileNo, other.mobileNo) && studentId == other.studentId;
	}

	 
	 
}
