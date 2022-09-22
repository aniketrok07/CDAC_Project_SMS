package com.app.controller;

import java.util.ArrayList;
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

import com.app.dto.ClassDTO;
import com.app.dto.FindSchedule;
import com.app.dto.ScheduleDTO;
import com.app.entities.Schedule;
import com.app.repository.ScheduleRepository;
import com.app.service.ScheduleServiceImpl;
@RestController
@RequestMapping("/api/v1/schedule")
@CrossOrigin(origins = "http://localhost:3000")
public class ScheduleController {
	
	@Autowired
	public ScheduleServiceImpl schServ;
	
	@Autowired
	public ScheduleRepository repo;
	
	public ScheduleController() {
		// TODO Auto-generated constructor stub
		System.out.println("in schedule controller");
	}
	
	@PostMapping("/addSchedule")
	public ResponseEntity<?> addSchedule(@RequestBody ScheduleDTO scd){
		Schedule sch = schServ.addSchedule(scd);
		Map<String,Object> map = new HashMap<>();
		if(sch!=null) {
			map.put("status", "success");
		}else {
			map.put("status", "error");
		}
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/viewSchedule")
	List<FindSchedule> viewSchedule(@RequestBody ClassDTO cd)
	{
		List<Object[]> list =repo.findScheduleByClassId(cd.getClassid());
		List<FindSchedule> fs = new ArrayList<>();
		
		for(Object[] obj:list)
		{
			String day = (String) obj[0];
			String subjectName = (String) obj[1];
			int starttime = (int) obj[2];
			int endtime = (int) obj[3];
			int classId = (int) obj[4];
			String firstname = (String) obj[5];
			FindSchedule fnew = new FindSchedule(day,subjectName,starttime,endtime,classId,firstname);
			fs.add(fnew);
		}
		
		return fs;
	}

}
