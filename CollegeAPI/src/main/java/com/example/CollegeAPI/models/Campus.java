package com.example.CollegeAPI.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Campus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;
	
	@OneToMany(targetEntity=Department.class,cascade=CascadeType.ALL)
	@JoinColumn(name="campusid_fk",referencedColumnName="id")
	private List<Department> departments;
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Campus(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	
	@Override
	public String toString() {
		return "Campus [id=" + id + ", name=" + name + ", location=" + location + ", departments=" + departments + "]";
	}
	
	public Campus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Campus(int id, String name, String location, List<Department> departments) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.departments = departments;
	}
	
	

}
