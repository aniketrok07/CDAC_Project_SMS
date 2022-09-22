package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AttendanceDTO {
	
	public Integer studentid;
	public LocalDate date;
	public String status;
	

}
