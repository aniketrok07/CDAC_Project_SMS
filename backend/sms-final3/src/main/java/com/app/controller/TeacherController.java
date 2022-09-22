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

import com.app.dto.AddMarksDTO;
import com.app.dto.ClassStudIdDTO;
import com.app.dto.TeacherDTO;
import com.app.dto.TeacherViewDTO;
import com.app.dto.ViewMarksDTO;
import com.app.entities.Marks;
import com.app.service.MarksServiceImpl;
import com.app.service.TeacherServiceImpl;

@RestController
@RequestMapping("/api/v1/teacher")
@CrossOrigin(origins = "http://localhost:3000")
public class TeacherController {
	
	@Autowired
	public TeacherServiceImpl teachServ;
	
	@Autowired
	public MarksServiceImpl marksServ;
	
	public TeacherController() {
		// TODO Auto-generated constructor stub
		System.out.println("in teacher controller");
	}
	
	@PostMapping("/addTeacher")
	public ResponseEntity<?> addTeacher(@RequestBody TeacherDTO teacher)
	{
		teachServ.addTeacher(teacher);
		Map<String,Object> map = new HashMap<>();
		map.put("status", "success");
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("/viewTeacher")
	public List<TeacherViewDTO> viewTeacher()
	{
		return teachServ.viewTeacher();
	}
	
	@PostMapping("/addMarks")
	public ResponseEntity<?> addMarks(@RequestBody AddMarksDTO amd)
	{
		Marks mks = marksServ.addMarks(amd);
		Map<String,Object> map = new HashMap<>();
		if(mks!=null)
		{
			map.put("status", "success");
		}
		else
		{
			map.put("status", "fail");
		}
		
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/viewMarks")
	public List<ViewMarksDTO> viewMarks(@RequestBody ClassStudIdDTO csd)
	{
		List<ViewMarksDTO> ls = marksServ.viewMarks(csd);
		return ls;
	}
	
	

}
