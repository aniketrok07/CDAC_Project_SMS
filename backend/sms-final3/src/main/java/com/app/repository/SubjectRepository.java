package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	@Query(value="select subject_id,subject_name,total_mark,class_id,first_name from subject_tbl s,teacher_tbl t,user_tbl u where t.user_id=u.user_id and s.class_id=:classId",nativeQuery=true)
	List<Object[]> findSubjectByClassId(@Param("classId") int classID);
	

}
