package com.app.service;

import java.util.List;

import com.app.entities.Notice;

public interface INoticeService {
	
	List<Notice> getAllNotice();
	
	Notice saveNotice(Notice notice);
	
	boolean deleteNotice(int id);

}
