package com.app.service;

import java.util.List;

import com.app.dto.TeacherDTO;
import com.app.dto.TeacherViewDTO;
import com.app.entities.Teacher;

public interface ITeacherService {
	
	Teacher addTeacher(TeacherDTO teacher);
	
	List<TeacherViewDTO> viewTeacher();
	
	
	
	

}
