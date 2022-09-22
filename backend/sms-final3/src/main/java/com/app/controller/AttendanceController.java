package com.app.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AttendanceDTO;
import com.app.dto.ClassStudIdDTO;
import com.app.dto.ViewAttendanceDTO;
import com.app.dto.ViewSubjectDTO;
import com.app.entities.Attendance;
import com.app.entities.Student;
import com.app.repository.AttendanceRepository;
import com.app.repository.StudentRepository;
import com.app.service.AttendanceServiceImpl;
@RestController
@RequestMapping("/api/v1/attendance")
@CrossOrigin(origins = "http://localhost:3000")
public class AttendanceController {
	
	@Autowired
	public AttendanceRepository attenRepo;
	
	@Autowired
	public StudentRepository studRepo;
	
	@Autowired
	public AttendanceServiceImpl attenServ;
	
	@PostMapping("/addAttendance")
	public ResponseEntity<?> addAtten(@RequestBody AttendanceDTO atten) {
		Attendance newAtten = new Attendance();
		System.out.println(atten.getStudentid());
		Student student = studRepo.getById(atten.getStudentid());
		
		
		newAtten.setDate(atten.getDate());
		newAtten.setStudent(student);
		newAtten.setAttenStatus(atten.getStatus());
		attenRepo.save(newAtten);
		Map<String,Object> map = new HashMap<>();
		map.put("status", "success");
		return ResponseEntity.ok(map);
		
	}
	
	@PostMapping("/viewAttendance")
	public List<ViewAttendanceDTO> viewAttendance(@RequestBody ClassStudIdDTO csd)
	{
		List<ViewAttendanceDTO> ls = attenServ.viewAttendance(csd);
		return ls;
	}
	
	

}
