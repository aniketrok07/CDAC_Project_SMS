package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ClassStudIdDTO;
import com.app.dto.SubjectDTO;
import com.app.dto.ViewMarksDTO;
import com.app.dto.ViewSubjectDTO;
import com.app.entities.Class;
import com.app.entities.Subject;
import com.app.entities.Teacher;
import com.app.repository.ClassRepository;
import com.app.repository.SubjectRepository;
import com.app.repository.TeacherRepository;
@Service
@Transactional
public class SubjectServiceImpl implements ISubjectService {
	
	@Autowired
	private ClassRepository classRepo;
	
	@Autowired
	private TeacherRepository teachRepo;
	
	@Autowired
	private SubjectRepository subRepo;

	@Override
	public Subject addSubject(SubjectDTO subject) {
		Subject newSub = new Subject();
		Class cls = classRepo.getById(subject.getClassId());
		Teacher teach = teachRepo.getById(subject.getTeacherId());
		newSub.setSubjectName(subject.getSubjectName());
		newSub.setTotalMarks(subject.getTotalmark());
		newSub.setCls(cls);
		newSub.setTeacher(teach);
		subRepo.save(newSub);
		return newSub;
	}
	
	@Override
	public List<ViewSubjectDTO> viewSubject(ClassStudIdDTO csd) {
		List<Object[]> list = subRepo.findSubjectByClassId(csd.getClassId());
		List<ViewSubjectDTO> vm = new ArrayList<>();
		
		for(Object[] obj:list)
		{
			int subjectId = (int) obj[0];
			String subjectName = (String) obj[1];
			int totalmark = (int) obj[2];
			int classId = (int) obj[3];
			String firstName = (String) obj[4];
			ViewSubjectDTO v = new ViewSubjectDTO(subjectId,subjectName,totalmark,classId,firstName);
			vm.add(v);
		}
		return vm;

}
}
