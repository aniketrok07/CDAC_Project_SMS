package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString.Exclude;

@Entity
@Table(name="student_tbl")
@Getter
@Setter
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private Integer studentId;
	
	@Column(name="fees_paid")
	private int feesPaid;
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="class_id",referencedColumnName="class_id")
	private Class cls;
	
	
	@OneToMany(mappedBy="student",fetch=FetchType.EAGER)
	Set<Attendance> attendances = new HashSet<>();
	
	@Exclude
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="user_id",referencedColumnName = "user_id" )
	private User user;
	
	@OneToMany(mappedBy="student",fetch=FetchType.EAGER)
	Set<Marks> marks = new HashSet<>();
	
	

}