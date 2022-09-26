package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="class_tbl")
@Getter
@Setter
public class Class {
	@Id
	private int class_id;
	
	
	@OneToMany(mappedBy = "cls",cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
	private Set<Student> students =new HashSet<>();
	
	@OneToOne
	@JoinColumn(name="teachrep_id",referencedColumnName="teacher_id")
	private Teacher teacher;
	
	
	
	@OneToMany(mappedBy = "cls",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Subject> subject =new HashSet<>();
	
	
	
	
	
	
	
	
	

}