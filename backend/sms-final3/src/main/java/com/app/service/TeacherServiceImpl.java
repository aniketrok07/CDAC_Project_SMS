package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.TeacherDTO;
import com.app.dto.TeacherViewDTO;
import com.app.entities.Teacher;
import com.app.entities.User;
import com.app.repository.TeacherRepository;
import com.app.security.AES;
@Service
@Transactional
public class TeacherServiceImpl implements ITeacherService {
	
	@Autowired
	private TeacherRepository teachRepo;
	
	AES a = new AES();

	@Override
	public Teacher addTeacher(TeacherDTO teacher) {
		
		final String secretKey = "ssshhhhhhhhhhh!!!!";
		String password = AES.encrypt(teacher.getPassword(), secretKey);
		
		Teacher newteach=new Teacher();
		User newUser=new User();
		newUser.setFname(teacher.getFname());
		newUser.setLname(teacher.getLname());
		newUser.setEmail(teacher.getEmail());
		newUser.setPassword(password);
		newUser.setAddressLine(teacher.getAddressLine());
		newUser.setCity(teacher.getCity());
		newUser.setPincode(teacher.getPincode());
		newUser.setSecurityCode(teacher.getSecurityCode());
		newUser.setRole(teacher.getRole());
		newteach.setDesignation(teacher.getDesignation());
		newteach.setSalary(teacher.getMonthSalary());
		newteach.setUser(newUser);
		teachRepo.save(newteach);
		return newteach;
	}

	@Override
	public List<TeacherViewDTO> viewTeacher() {
		List<TeacherViewDTO> tvd = new ArrayList<>();
		List<Object[]> list = teachRepo.findAllTeachers();
		
		for(Object[] obj:list)
		{
			int teacherId= (int) obj[0];
			String fname=(String) obj[1];
			String lname=(String) obj[2];
			String designation=(String) obj[3];
			int monthSalary=(int) obj[4];
			TeacherViewDTO newT = new TeacherViewDTO(teacherId,fname,lname,designation,monthSalary);
			tvd.add(newT);
		}
		return tvd;
	}

	
	

	
	

}
