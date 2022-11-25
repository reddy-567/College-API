package com.example.CollegeAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.CollegeAPI.models.Section;
import com.example.CollegeAPI.models.Student;

public interface SectionRepository extends JpaRepository<Section,Integer>{

	@Query("select st from Section s JOIN s.students st where s.id=?1")
	public List<Student> getStudentsBySectionId(int id);
	
	
}
