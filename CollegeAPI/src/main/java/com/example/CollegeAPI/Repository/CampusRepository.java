package com.example.CollegeAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.CollegeAPI.dto.Branches;
import com.example.CollegeAPI.models.Campus;

public interface CampusRepository extends JpaRepository<Campus,Integer>{
	
	@Query("SELECT new com.example.CollegeAPI.dto.Branches(c.name, d.dname) FROM Campus c JOIN c.departments d")
	public List<Branches> getJoinInformation();
	
	
	@Query("SELECT  d.dname,'with id',d.id FROM Campus c JOIN c.departments d where c.id=?1")
	public List<String> getBranchesByCampusId(int id);
	
	@Query("SELECT name,id From Campus")
	public List<String> getCampusNames();
	
	
	

}
