package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query(value="select student_id,first_name,last_name,s.class_id,fees_paid"
			+ " from user_tbl u,student_tbl s where s.class_id=:classId and u.role="+"'student'"+" and u.user_id=s.user_id",nativeQuery=true)
	List<Object[]> findStudnetByClassId(@Param("classId") int classID);
	

	

}
