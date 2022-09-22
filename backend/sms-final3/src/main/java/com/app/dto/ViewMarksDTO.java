package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ViewMarksDTO {
	private int subjectId;
	private String subjectName;
	private int marks;
	private String firstName;
	private int classId;
	public ViewMarksDTO(int subjectId, String subjectName, int marks, String firstName, int classId) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.marks = marks;
		this.firstName = firstName;
		this.classId = classId;
		}
}