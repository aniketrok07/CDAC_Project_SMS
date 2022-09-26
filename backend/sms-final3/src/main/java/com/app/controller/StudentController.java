package com.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ClassDTO;
import com.app.dto.FindStudent;
import com.app.dto.PayFeesDTO;
import com.app.dto.StudentDTO;
import com.app.entities.Student;
import com.app.repository.StudentRepository;
import com.app.service.StudentServiceImpl;
import com.app.service.SubjectServiceImpl;

@RestController
@RequestMapping("/api/v1/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	
	@Autowired
	public SubjectServiceImpl subServ;
	
	@Autowired
	public StudentRepository repo;
	
	@Autowired
	public StudentServiceImpl studServ;
	
	
	@PostMapping("/addStudent")
	public ResponseEntity<?> addStudent(@RequestBody StudentDTO stud)
	{
		Student st=studServ.addStudent(stud);
		Map<String,Object> map = new HashMap<>();
		if(st!=null) {
		map.put("status", "success");}
		else {
			map.put("status", "failure");
		}
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/addFees")
	public ResponseEntity<?> addFees(@RequestBody PayFeesDTO pfd){
		String mesg = studServ.payFees(pfd);
		Map<String,Object> map = new HashMap<>();
		if(mesg=="success") {
			map.put("status", "success");
		}else {
			map.put("status","Already fees paid");
		}
		return ResponseEntity.ok(map);
	}
		
	
	@PostMapping("/findStudent")
	public List<FindStudent> findStudent(@RequestBody ClassDTO cd)
	{
		List<Object[]> list =repo.findStudnetByClassId(cd.getClassid());
		List<FindStudent> fs = new ArrayList<>();
		
		for(Object[] obj:list)
		{
			int student_id = (int) obj[0];
			String first_name = (String) obj[1];
			String last_name = (String) obj[2];
			int class_id = (int) obj[3];
			int fees_paid=(int)obj[4];
			FindStudent fsnew = new FindStudent(student_id,first_name,last_name,class_id,fees_paid);
			fs.add(fsnew);
		}
		
		
		return fs;		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer id)
	{
		Student stud = repo.getById(id);
		Map<String,Object> map = new HashMap<>();
		if(stud!=null)
		{
			repo.deleteById(id);
			map.put("status", "success");
			
		}else {
			map.put("status", "error");
		}
		
		return ResponseEntity.ok(map);
		
	}
	

}
