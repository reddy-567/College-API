package com.example.CollegeAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.CollegeAPI.Repository.CampusRepository;
import com.example.CollegeAPI.Repository.DepartmentRepository;
import com.example.CollegeAPI.models.Campus;
import com.example.CollegeAPI.models.Department;

@SpringBootApplication
public class CollegeApiApplication/* implements CommandLineRunner*/{

	@Autowired
	private CampusRepository c;
	@Autowired
	private DepartmentRepository d;
	public static void main(String[] args) {
		SpringApplication.run(CollegeApiApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Campus c1=new Campus("IIIT ONGOLE","ONGOLE");
		c.save(c1);
		Department d1=new Department(2,"ECE","RatnaKumari",c1);
		d.save(d1); 
	
	}*/

}
