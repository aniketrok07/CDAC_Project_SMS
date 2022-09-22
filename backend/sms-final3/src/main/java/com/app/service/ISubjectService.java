package com.app.service;

import java.util.List;

import com.app.dto.ClassStudIdDTO;
import com.app.dto.SubjectDTO;
import com.app.dto.ViewSubjectDTO;
import com.app.entities.Subject;

public interface ISubjectService {
	
	Subject addSubject(SubjectDTO subject);

	List<ViewSubjectDTO> viewSubject(ClassStudIdDTO csd);

}
