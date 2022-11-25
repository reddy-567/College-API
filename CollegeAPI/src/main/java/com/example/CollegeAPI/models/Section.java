package com.example.CollegeAPI.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Section {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String sname;
	private int noOfStudents=0;
	
	@OneToMany(targetEntity=Student.class,cascade=CascadeType.ALL)
	@JoinColumn(name="sec_id",referencedColumnName="id")
	private List<Student> students;
	public int getId() {
		return id;
	}
	
	
	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		
		this.students = students;
		this.noOfStudents=this.students.size();
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return sname;
	}
	public void setName(String name) {
		this.sname = name;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	@Override
	public String toString() {
		return "Section [id=" + id + ", name=" + sname + ", noOfStudents=" + noOfStudents + "]";
	}
	public Section(int id, String name, int noOfStudents) {
		super();
		this.id = id;
		this.sname = name;
		this.noOfStudents = noOfStudents;
	}
	public Section() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
