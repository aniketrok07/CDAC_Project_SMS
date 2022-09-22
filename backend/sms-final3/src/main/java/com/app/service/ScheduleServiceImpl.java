package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ScheduleDTO;
import com.app.entities.Schedule;
import com.app.entities.Subject;
import com.app.repository.ScheduleRepository;
import com.app.repository.SubjectRepository;

@Service
@Transactional
public class ScheduleServiceImpl implements IScheduleService {
	
	@Autowired
	private SubjectRepository subRepo;
	
	@Autowired
	private ScheduleRepository schRepo;

	@Override
	public Schedule addSchedule(ScheduleDTO schedule) {
		Schedule sch = new Schedule();
		Subject sub = subRepo.getById(schedule.getSubjectId());
		sch.setDay(schedule.getDay());
		sch.setStarttime(schedule.getStarttime());
		sch.setEndtime(schedule.getEndtime());
		sch.setSubject(sub);
		schRepo.save(sch);
		return sch;
	}
	
	

}
