package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddClassDTO;
import com.app.entities.Class;
import com.app.service.ClassServiceImpl;

@RestController
@RequestMapping("/api/v1/class")
@CrossOrigin(origins = "http://localhost:3000")
public class ClassController {
	
	@Autowired
	public ClassServiceImpl classServ;
	
	@PostMapping("/addClass")
	public ResponseEntity<?> addClass(@RequestBody AddClassDTO acd){
		
		Class cls=classServ.addClass(acd);
		Map<String,Object> map = new HashMap<>();
		if(cls!=null) {
			map.put("status", "success");
		}else {
		map.put("status", "error");
		}
		return ResponseEntity.ok(map);
		
	}

}
