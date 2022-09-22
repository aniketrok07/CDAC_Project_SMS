package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleDTO {
	
	private String day;
	private int starttime;
	private int endtime;
	private int subjectId;

}
