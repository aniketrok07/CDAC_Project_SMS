package com.app.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ClassStudIdDTO;
import com.app.dto.ViewAttendanceDTO;
import com.app.repository.AttendanceRepository;
@Service
@Transactional
public class AttendanceServiceImpl implements IAttendanceService {

	@Autowired
	public AttendanceRepository attenRepo;
	@Override
	public List<ViewAttendanceDTO> viewAttendance(ClassStudIdDTO csd) {
		List<Object[]> list = attenRepo.findAttendance(csd.getStudId());
		List<ViewAttendanceDTO> vm = new ArrayList<>();
		
		for(Object[] obj:list)
		{
			int studentId = (int) obj[0];
			String firstName = (String) obj[1];
			String lastName = (String) obj[2];
			int classId = (int) obj[3];
			Date date = (Date) obj[4];
			String status=(String) obj[5];
			ViewAttendanceDTO v = new ViewAttendanceDTO(studentId,firstName,lastName,classId, date,status);
			vm.add(v);
		}
		return vm;
		
	}

}
