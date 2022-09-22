package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString.Exclude;
@Entity
@Table(name="teacher_tbl")
@Getter
@Setter
@NoArgsConstructor
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="teacher_id")
	private Integer teacherId;
	
	@Column(name="designation",length=20)
	private String designation;
	
	@Column(name="mon_salary")
	private int salary;
	
	@Exclude
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="user_id",referencedColumnName = "user_id" )
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy = "teacher")
	private Set<Subject> subjects =new HashSet<>();
	

}
