package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Notice;
import com.app.repository.NoticeRepository;
@Service
@Transactional
public class NoticeServiceImpl implements INoticeService {
	
	@Autowired
	public NoticeRepository noticeRepo;

	@Override
	public List<Notice> getAllNotice() {
		
		return noticeRepo.findAll();
	}

	@Override
	public Notice saveNotice(Notice notice) {
		
		return noticeRepo.save(notice);
	}
	
	@Override
	public boolean deleteNotice(int id) {
		noticeRepo.deleteById(id);
			return true;
		}
		
		
	}
	


