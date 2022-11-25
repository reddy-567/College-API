package com.example.CollegeAPI.dto;

public class Branches {

	private String name;
	private String dname;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepName() {
		return dname;
	}
	public void setDepName(String depName) {
		this.dname = depName;
	}
	public Branches(String name, String depName) {
		super();
		this.name = name;
		this.dname = depName;
	}
	
	@Override
	public String toString() {
		return "Branches [name=" + name + ", dname=" + dname + "]";
	}
	public Branches() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
