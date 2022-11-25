package com.example.CollegeAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.CollegeAPI.dto.StudentDetails;
import com.example.CollegeAPI.models.Department;
import com.example.CollegeAPI.models.Section;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{
	
	//public List<Department> findByDname(String name);
	
	//public List<Department> findByCampusid_fk(int id);
	@Query("select d.dname,s.sname from Department d JOIN d.sections s where d.id=?1")
	public List<String> getbranchesAndSections();
	
	@Query("select s from Department d JOIN d.sections s where d.id=?1")
	public List<Section> getSectionsbyBranchId(int id);
	
	@Query("select new com.example.CollegeAPI.dto.StudentDetails(st.studentName,d.dname,s.sname) FROM Department d JOIN d.sections s JOIN s.students st")
	public List<StudentDetails> getStudentDetails();
	
	@Query("select new com.example.CollegeAPI.dto.StudentDetails(st.studentName,d.dname,s.sname) FROM Department d JOIN d.sections s JOIN s.students st where st.id=?1")
	public StudentDetails getStudentDetailsbyId(int id);

}
