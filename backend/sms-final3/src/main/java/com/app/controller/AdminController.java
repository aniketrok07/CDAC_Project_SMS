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

import com.app.dto.AdminDTO;
import com.app.entities.User;
import com.app.service.StudentServiceImpl;
import com.app.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
	@Autowired
	public StudentServiceImpl studServ;
	
	
	
	@Autowired
	public UserServiceImpl adminServ;
	
	
	
	
	
	
	
	
	public AdminController() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	@PostMapping("/addAdmin")
	public ResponseEntity<?> addAdmin(@RequestBody AdminDTO admin)
	{
		User adm = adminServ.addAdmin(admin);
		Map<String,Object> map = new HashMap<>();
		if(adm!=null) {
		map.put("status", "success");
		}else {
		map.put("status", "error");
		}
		return ResponseEntity.ok(map);
	}
	
	
	
	
	
	

}
