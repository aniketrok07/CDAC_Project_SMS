package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.PayFeesDTO;
import com.app.dto.StudentDTO;
import com.app.entities.Class;
import com.app.entities.Student;
import com.app.entities.User;
import com.app.repository.ClassRepository;
import com.app.repository.StudentRepository;
import com.app.repository.UserRepository;
import com.app.security.AES;
@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	public StudentRepository studRepo;
	
	@Autowired
	public ClassRepository classRepo;
	
	@Autowired
	public UserRepository userRepo;
	
	AES a = new AES();

	@Override
	public Student addStudent(StudentDTO stud) {
		
		User u = userRepo.findByEmail(stud.getEmail());
		System.out.println(u);
		if(u==null) {
		
		final String secretKey = "ssshhhhhhhhhhh!!!!";
		String password = AES.encrypt(stud.getPassword(), secretKey);
		
		Student newStud=new Student();
		Class cls = classRepo.getById(stud.getClassId());
		User newUser=new User();
		newUser.setFname(stud.getFname());
		newUser.setLname(stud.getLname());
		newUser.setEmail(stud.getEmail());
		newUser.setPassword(password);
		newUser.setAddressLine(stud.getAddressLine());
		newUser.setCity(stud.getCity());
		newUser.setPincode(stud.getPincode());
		newUser.setSecurityCode(stud.getSecurityCode());
		newUser.setRole(stud.getRole());
		newStud.setCls(cls);
		newStud.setUser(newUser);
		studRepo.save(newStud);
		return newStud;}
		else {
			return null;
		}
		
	}

	@Override
	public String payFees(PayFeesDTO pfd) {
		Student stud = studRepo.getById(pfd.getStudentId());
	    int fees = stud.getFeesPaid();
	    if(fees<20000) {
	    fees=fees+pfd.getFeeamount();
	    stud.setFeesPaid(fees);
	    return "success";
	    }else {
	    	return "fail";
	    }
	    
		
	}
	@Override
	public List<Student> viewStudents() {
		List<Student> student=studRepo.findAll();
		return student;
		
	}
	
	
	
	
	
	
	

}
