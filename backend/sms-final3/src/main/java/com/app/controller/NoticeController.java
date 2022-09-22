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

import com.app.entities.Notice;
import com.app.service.INoticeService;

@RestController
@RequestMapping("/api/v1/notice")
@CrossOrigin(origins = "http://localhost:3000")
public class NoticeController {
	
	@Autowired
	public INoticeService noticeService;
	
	public NoticeController() {
		System.out.println("in notice controller");
	}
	
	@GetMapping
	public List<Notice> getAllNotices()
	{
		return noticeService.getAllNotice();
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<?> save(@RequestBody Notice notice)
	{
		Notice not = noticeService.saveNotice(notice);
		Map<String,Object> map = new HashMap<>();
		if(not!=null) {
			map.put("status", "success");
		}else {
			map.put("status", "error");
		}
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody Notice notice)
	{
		boolean not = noticeService.deleteNotice(notice.getNoticeId());
		Map<String,Object> map = new HashMap<>();
		if(not==true) {
			map.put("status", "success");
		}else {
			map.put("status", "error");
		}
		return ResponseEntity.ok(map);
	}
	
	
	

}
