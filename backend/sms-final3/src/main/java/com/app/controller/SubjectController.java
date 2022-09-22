package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ClassStudIdDTO;
import com.app.dto.SubjectDTO;
import com.app.dto.ViewSubjectDTO;
import com.app.entities.Subject;
import com.app.service.SubjectServiceImpl;
@RestController
@RequestMapping("/api/v1/subject")
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {
	
	@Autowired
	private SubjectServiceImpl subServ;
	
	public SubjectController() {
		// TODO Auto-generated constructor stub
		System.out.println("subject contoller");
	}
	
	@PostMapping("/addSubject")
	public ResponseEntity<?> addSubject(@RequestBody SubjectDTO sd){
		Subject sub = subServ.addSubject(sd);
		Map<String,Object> map = new HashMap<>();
		if(sub!=null) {
			map.put("status", "success");
		}else {
		map.put("status", "error");
		}
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/viewSubject")
	public List<ViewSubjectDTO> viewSubject(@RequestBody ClassStudIdDTO csd)
	{
		List<ViewSubjectDTO> ls = subServ.viewSubject(csd);
		return ls;
	}
	

}
