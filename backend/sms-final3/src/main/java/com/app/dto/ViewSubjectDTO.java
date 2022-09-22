package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewSubjectDTO {

	private int subjectId;
	private String subjectName;
	private int totalMark;
	private int classId;
	private String fname;
	public ViewSubjectDTO(int subjectId, String subjectName, int totalMark, int classId, String fname) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.totalMark = totalMark;
		this.classId = classId;
		this.fname = fname;
	}
	
	
	
}
