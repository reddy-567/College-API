
//This controller is for rest end points
package com.example.CollegeAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CollegeAPI.Repository.CampusRepository;
import com.example.CollegeAPI.Repository.DepartmentRepository;
import com.example.CollegeAPI.Repository.SectionRepository;
import com.example.CollegeAPI.Repository.StudentRepository;
import com.example.CollegeAPI.dto.Branches;
import com.example.CollegeAPI.dto.StudentDetails;
import com.example.CollegeAPI.models.Campus;
import com.example.CollegeAPI.models.Department;
import com.example.CollegeAPI.models.Section;
import com.example.CollegeAPI.models.Student;

//@RestController
public class MyController {
	
	@Autowired
	private CampusRepository c_repo;
	@Autowired
	public DepartmentRepository d_repo;
	@Autowired
	private SectionRepository s_repo;
	@Autowired
	private StudentRepository st_repo;
	
	@PostMapping("/addCampus")
	public Campus addCampus(@RequestBody Campus campus)
	{
		return c_repo.save(campus);
		//return "campus added successfully";
	}
	
	@PutMapping("/addDepartmentToCampus/{id}")
	public Campus addCampus(@PathVariable("id") int id,@RequestBody Department department)
	{
		Campus c=c_repo.findById(id).orElse(null);
		if(c!=null)
		{
			List<Department> l=c.getDepartments();
			l.add(department);
			c.setDepartments(l);
			
		return c_repo.save(c);
		}
		else
			return null;
		//return "campus added successfully";
	}
	
	@PutMapping("/addSectionToDepartment/{id}")
	public Department addDepartment(@PathVariable("id") int id,@RequestBody Section section)
	{
		Department d=d_repo.findById(id).orElse(null);
		if(d!=null)
		{
			List<Section> s=d.getSections();
			s.add(section);
			section.setNoOfStudents(section.getStudents().size());
			d.setSections(s);
			return d_repo.save(d);
		}
		else
			return null;
	}
	@PostMapping("/addDepartment")
	public Department addDepartment(@RequestBody Department dep)
	{
		return d_repo.save(dep);
		
	}
	
	
	//@GetMapping("/departments/{id}")
	//public List<Department> getDepartments(@PathVariable("id") int id)
	{
	//	return d_repo.findByCampuid_fk();
	}
	
	
	@GetMapping("/")
	public List<Campus> getAllCampuses()
	{
		return c_repo.findAll();
	}
	
	@GetMapping("/getAllDepartments")
	public List<Department> getAllDepartments()
	{
		return d_repo.findAll();
	}
	
	@GetMapping("/campuses/departments")
	public List<Branches> getDepartments()
	{
		return c_repo.getJoinInformation();
	}
	
	@GetMapping("/departments/sections")
	public List<String> getDepartmentsAndSections()
	{
		return d_repo.getbranchesAndSections();
	}
	
	@GetMapping("/campuses")
	public List<String> getCampuses(){
		return c_repo.getCampusNames();
	}
	
	@GetMapping("/campus/{id}")
	public Campus getCampus(@PathVariable("id") int id)
	{
		return c_repo.findById(id).orElse(null);
	}
	
	@GetMapping("/section/{id}")
	public Section getSection(@PathVariable("id") int id)
	{
		return s_repo.findById(id).orElse(null);
	}

	@GetMapping("/students")
	public List<Student> getStudent()
	{
		return st_repo.findAll();
	}
	
	@GetMapping("/studentDetails")
	public List<StudentDetails> getStudentDetails()
	{
		return d_repo.getStudentDetails();
	}
	

	@GetMapping("/studentDetails/{id}")
	public StudentDetails getStudentDetails(@PathVariable("id") int id)
	{
		return d_repo.getStudentDetailsbyId(id);
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student)
	{
		return st_repo.save(student);
		
	}
	
	@PutMapping("/addStudentsToSection/{id}")
	public Section addStudentsToSection(@PathVariable("id") int id,@RequestBody Student student)
	{
		Section s=s_repo.findById(id).orElse(null);
		if(s!=null)
		{
			List<Student> l=s.getStudents();
			l.add(student);
			s.setStudents(l);
			s.setNoOfStudents(s.getStudents().size());
			return s_repo.save(s);
		}
		return null;
	}
	
	@DeleteMapping("/deleteSection/{id}")
	public String deleteSection(@PathVariable("id") int id)
	{
		try
		{
		s_repo.deleteById(id);
		return "section deleted successfully";
		}
		catch(Exception e)
		{
			return "Section is not exist with given id";
		}
	}
	
	@DeleteMapping("/deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable("id") int id)
	{
		try
		{
		d_repo.deleteById(id);
		return "Department deleted successfully";
		}
		catch(Exception e)
		{
			return "Department is not exist with given id";
		}
	}
	
	@DeleteMapping("/deleteCampus/{id}")
	public String deleteCampus(@PathVariable("id") int id)
	{
		try
		{
		c_repo.deleteById(id);
		return "campus deleted successfully";
		}
		catch(Exception e)
		{
			return "campus is not exist with given id";
		}
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") int id)
	{
		try
		{
		st_repo.deleteById(id);
		return "student deleted successfully";
		}
		catch(Exception e)
		{
			return "Student is not exist with given id";
		}
	}
	
	@PutMapping("/updateDepartment/{id}")
	public Department updateDepartment(@PathVariable("id") int id,@RequestBody Department department)
	{
		Department d=d_repo.findById(id).orElse(null);
		if(d!=null)
		{
			if(department.getHOD()!=null)
			d.setHOD(department.getHOD());
			if(department.getName()!=null)
			d.setName(department.getName());
			return d_repo.save(d);
		}
		else
			return null;
	}
}
