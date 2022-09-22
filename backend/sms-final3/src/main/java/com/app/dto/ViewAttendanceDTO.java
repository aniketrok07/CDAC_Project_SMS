package com.app.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewAttendanceDTO {

	
	private int studentId;
	private String firstName;
	private String lastName;
	private int classId;
	private Date date;
	private String status;
	public ViewAttendanceDTO(int studentId, String firstName, String lastName, int classId, Date date, String status) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.classId = classId;
		this.date = date;
		this.status = status;
	}
}
