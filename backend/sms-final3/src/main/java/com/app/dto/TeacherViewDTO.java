package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherViewDTO {
	
    private int teacherId;
    private String fname;
    private String lname;
    private String designation;
    private int monthSalary;
	public TeacherViewDTO(int teacherId, String fname, String lname, String designation, int monthSalary) {
		super();
		this.teacherId = teacherId;
		this.fname = fname;
		this.lname = lname;
		this.designation = designation;
		this.monthSalary = monthSalary;
	}
    
    

}
