package com.app.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthenticateDTO;
import com.app.dto.ForgotPasswordDTO;
import com.app.dto.UpdateUserDTO;
import com.app.dto.UserIdDTO;
import com.app.entities.User;
import com.app.repository.UserRepository;
import com.app.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	public UserServiceImpl userserv;
	
	@Autowired
	public UserRepository userRepo;
	
	public UserController() {
		// TODO Auto-generated constructor stub
		System.out.println("in user controller");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestBody AuthenticateDTO auth){
		User loguser = userserv.findByEmail(auth);
		Map<String,Object> map = new HashMap<>();
		if(loguser!=null) {
			map.put("status", "success");
			map.put("data", loguser.getRole());
			map.put("user", loguser.getUserId());
			return ResponseEntity.ok(map);
		}else {
			map.put("status", "error");
			map.put("error", "User not found, Please check entered email or password");
			return ResponseEntity.ok(map);
		}
	}
	
	@PostMapping("/myprofile")
	public ResponseEntity<?> getUserDetails(@RequestBody UserIdDTO id){
		System.out.println(id.getUserid());
		Optional<User> user = userserv.getUserById(id);
		Map<String,Object> map = new HashMap<>();
		if(user!=null) {
			map.put("status","success");
			map.put("user", user);
			return ResponseEntity.ok(map);
		}else {
			map.put("status","error");
			return ResponseEntity.ok(map);
		}
	}
	
	
	@PostMapping("/updatePassword")
	public ResponseEntity<?> updatePassword(@RequestBody ForgotPasswordDTO fpd){
		User loguser = userRepo.findByEmail(fpd.getEmail());
		Map<String,Object> map = new HashMap<>();
		if(loguser!=null) {
			userserv.updatePassword(fpd);
			map.put("status", "success");
			return ResponseEntity.ok(map);
		}else {
			map.put("status", "wrong email or secret code");
			return ResponseEntity.ok(map);
		}
	}
	
	
	@PutMapping("/updateProfile")
	public ResponseEntity<?> updateProfile(@RequestBody UpdateUserDTO user)
	{
		User u1 = userserv.updateUser(user);
		Map<String,Object> map = new HashMap<>();
		if(u1!=null) {
			map.put("status","success");
			map.put("user", user);
			return ResponseEntity.ok(map);
		}else {
			map.put("status","error");
			return ResponseEntity.ok(map);
		}
	}
	
	
	
	

}
