package com.app.service;

import com.app.dto.ScheduleDTO;
import com.app.entities.Schedule;

public interface IScheduleService {
	
	Schedule addSchedule(ScheduleDTO schedule);

}
