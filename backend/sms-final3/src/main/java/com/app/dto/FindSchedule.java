package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindSchedule {
	
	private String day;
	private String subjectName;
	private int starttime;
	private int endtime;
	private int classID;
	private String firstName;
	public FindSchedule(String day, String subjectName, int starttime, int endtime, int classID, String firstName) {
		super();
		this.day = day;
		this.subjectName = subjectName;
		this.starttime = starttime;
		this.endtime = endtime;
		this.classID = classID;
		this.firstName = firstName;
	}
	
	
	

}
