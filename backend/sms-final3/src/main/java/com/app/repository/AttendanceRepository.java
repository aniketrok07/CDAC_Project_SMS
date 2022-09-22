package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

	@Query(value="select stud_id, first_name, last_name, class_id, date,status from atten_tbl a,student_tbl s,user_tbl u where s.user_id=u.user_id and stud_id=:studId",nativeQuery=true)
	List<Object[]> findAttendance(@Param("studId") int studId);

}
