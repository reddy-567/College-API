package com.example.CollegeAPI.dto;

public class StudentDetails {

	private String studentName;
	private String departmentName;
	private String sectionName;
	public String getStudent_name() {
		return studentName;
	}
	public void setStudent_name(String student_name) {
		this.studentName = student_name;
	}
	public String getDname() {
		return departmentName;
	}
	public void setDname(String dname) {
		this.departmentName = dname;
	}
	public String getSname() {
		return sectionName;
	}
	public void setSname(String sname) {
		this.sectionName = sname;
	}
	public StudentDetails(String student_name, String departmentName, String sname) {
		super();
		this.studentName = student_name;
		this.departmentName = departmentName;
		this.sectionName = sname;
	}
	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StudentDetails [student_name=" + studentName + ", Department name=" + departmentName + ", section name=" + sectionName + "]";
	}
	
	
}
