package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindStudent {
	
	public int student_id;
	public String first_name;
	public String last_name;
	public int class_id;
	public int fees_paid;
	public FindStudent(int student_id, String first_name, String last_name, int class_id, int fees_paid) {
		super();
		this.student_id = student_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.class_id = class_id;
		this.fees_paid = fees_paid;
	}
	
	
	

}
