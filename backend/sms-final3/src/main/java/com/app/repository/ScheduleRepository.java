package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
	@Query(value="select day,subject_name,starttime,endtime,class_id,first_name "
			+ "from schedule_tbl s,subject_tbl sb,teacher_tbl t,user_tbl u "
			+ "where t.user_id=u.user_id and sb.class_id=:classId and sb.teacher_id=t.teacher_id",nativeQuery=true)
	List<Object[]> findScheduleByClassId(@Param("classId") int classID);

}
