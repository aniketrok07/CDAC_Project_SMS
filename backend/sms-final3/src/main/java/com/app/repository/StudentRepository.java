package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Student;
import com.app.entities.User;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query(value="select student_id,first_name,last_name,s.class_id,fees_paid"
			+ " from user_tbl u,student_tbl s where s.class_id=:classId and u.role="+"'student'"+" and u.user_id=s.user_id",nativeQuery=true)
	List<Object[]> findStudnetByClassId(@Param("classId") int classID);
	
	@Query(value = "select * from user_tbl where email=:email", nativeQuery = true)
	User findByEmail(@Param("email") String email);
	

	

}
