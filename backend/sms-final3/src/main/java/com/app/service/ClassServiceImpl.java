package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AddClassDTO;
import com.app.entities.Class;
import com.app.entities.Teacher;
import com.app.repository.ClassRepository;
import com.app.repository.TeacherRepository;
@Service
@Transactional
public class ClassServiceImpl implements IClassService {
	
	@Autowired
	private TeacherRepository teachRepo;
	
	@Autowired
	private ClassRepository classRepo;

	@Override
	public Class addClass(AddClassDTO acd) {
		
		Teacher teach = teachRepo.getById(acd.getTeacherId());
		Class cls = new Class();
		cls.setClass_id(acd.getClassId());
		cls.setTeacher(teach);
		classRepo.save(cls);
		return cls;
		
	}
	
	

}
