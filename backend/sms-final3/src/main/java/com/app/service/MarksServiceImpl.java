package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AddMarksDTO;
import com.app.dto.ClassStudIdDTO;
import com.app.dto.ViewMarksDTO;
import com.app.entities.Marks;
import com.app.repository.MarksRepository;
import com.app.repository.StudentRepository;
import com.app.repository.SubjectRepository;
@Service
@Transactional
public class MarksServiceImpl implements IMarksService {
	
	@Autowired
	public StudentRepository studRepo;
	
	@Autowired
	public SubjectRepository subRepo;
	
	@Autowired
	public MarksRepository marksRepo;

	@Override
	public Marks addMarks(AddMarksDTO amd) {
		Marks mks = new Marks();
		mks.setMarks(amd.getMarks());
		mks.setStudent(studRepo.getById(amd.getStudentId()));
		mks.setSubject(subRepo.getById(amd.getSubjectId()));
		marksRepo.save(mks);
		return mks;
	}

	@Override
	public List<ViewMarksDTO> viewMarks(ClassStudIdDTO csd) {
		List<Object[]> list = marksRepo.findMarks(csd.getClassId(), csd.getStudId());
		List<ViewMarksDTO> vm = new ArrayList<>();
		
		for(Object[] obj:list)
		{
			int subjectId = (int) obj[0];
			String subjectName = (String) obj[1];
			int marks = (int) obj[2];
			String firstName = (String) obj[3];
			int classId = (int) obj[4];
			ViewMarksDTO v = new ViewMarksDTO(subjectId,subjectName,marks,firstName,classId);
			vm.add(v);
		}
		return vm;
	}
	
	
	
	

}
