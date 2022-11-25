package com.example.CollegeAPI.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String dname;
	private String HOD;
	
	@OneToMany(targetEntity=Section.class,cascade=CascadeType.ALL)
	@JoinColumn(name="dep_id",referencedColumnName="id")
	private List<Section> sections;
	
	
	//@ManyToOne
	//@JoinColumn(name="campus_id")
	//private Campus campus;
	
	
	public String getHOD() {
		return HOD;
	}
	public Department(int id, String name, String hOD, List<Section> sections) {
		super();
		this.id = id;
		this.dname = name;
		HOD = hOD;
		this.sections = sections;
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	public void setHOD(String hOD) {
		HOD = hOD;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return dname;
	}
	public void setName(String name) {
		this.dname = name;
	}
	public Department(int id, String name) {
		super();
		this.id = id;
		this.dname = name;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Department(int id, String name, String hOD) {
		super();
		this.id = id;
		this.dname = name;
		HOD = hOD;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + dname + ", HOD=" + HOD + ", sections=" + sections + "]";
	}

	
}
