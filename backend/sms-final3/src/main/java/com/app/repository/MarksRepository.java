package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Marks;

public interface MarksRepository extends JpaRepository<Marks, Integer>{
	@Query(value="select sb.subject_id,subject_name,marks,first_name,sb.class_id from marks_tbl m"
			+ ",subject_tbl sb,user_tbl u,student_tbl s where u.user_id=s.user_id and sb.class_id=:classId and stud_id=:studId and m.subject_id=sb.subject_id",nativeQuery=true)
	List<Object[]> findMarks(@Param("classId") int classID,@Param("studId") int studId);

}
