package com.example.CollegeAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CollegeAPI.models.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
