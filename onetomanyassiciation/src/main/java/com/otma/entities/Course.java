package com.otma.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Course {

	private int courseId;
	private String courseName;
	private LocalDate startingDate;
	private int durationInMonths;
	private double fee;
	private String trainerName;
	private String instituteName;
	private String contactNo;
	private Set<Student> students;
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public LocalDate getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}
	public int getDurationInMonths() {
		return durationInMonths;
	}
	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", startingDate=" + startingDate
				+ ", durationInMonths=" + durationInMonths + ", fee=" + fee + ", trainerName=" + trainerName
				+ ", instituteName=" + instituteName + ", contactNo=" + contactNo + ", students=" + students + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(contactNo, courseId, courseName, durationInMonths, fee, instituteName, startingDate,
				trainerName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(contactNo, other.contactNo) && courseId == other.courseId
				&& Objects.equals(courseName, other.courseName) && durationInMonths == other.durationInMonths
				&& Double.doubleToLongBits(fee) == Double.doubleToLongBits(other.fee)
				&& Objects.equals(instituteName, other.instituteName)
				&& Objects.equals(startingDate, other.startingDate) && Objects.equals(trainerName, other.trainerName);
	}
	
	
}
