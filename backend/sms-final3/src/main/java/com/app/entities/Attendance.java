package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="atten_tbl")
@Getter
@Setter
@NoArgsConstructor
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="atten_id")
	private Integer attenId;
	private LocalDate date;
	@Column(name="status",length=20)
	private String attenStatus;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="stud_id",referencedColumnName="student_id")
	private Student student;
	public Attendance(LocalDate date, String attenStatus, Student student) {
		super();
		this.date = date;
		this.attenStatus = attenStatus;
		this.student = student;
	}
	
	
	
	

}
