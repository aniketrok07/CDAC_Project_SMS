package com.app.service;

import java.util.List;

import com.app.dto.PayFeesDTO;
import com.app.dto.StudentDTO;
import com.app.entities.Student;

public interface IStudentService {
	
	public Student addStudent(StudentDTO stud);
	public String payFees(PayFeesDTO pfd);
	public List<Student> viewStudents();
	
}
