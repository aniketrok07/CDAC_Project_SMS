package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
	@Query(value="select teacher_id,first_name,last_name,designation,mon_salary from teacher_tbl"
			+ " t,user_tbl u where t.user_id=u.user_id",nativeQuery=true)
    List<Object[]> findAllTeachers();
	

}
