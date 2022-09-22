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
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="subject_tbl")
@Getter
@Setter
@NoArgsConstructor
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subject_id")
	private Integer subjectId;
	@Column(name="subject_name",length=20)
	private String subjectName;
	@Column(name="total_mark")
	private int totalMarks;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="teacher_id",referencedColumnName="teacher_id")
	private Teacher teacher;
	
	
	@OneToMany(mappedBy = "subject")
	private Set<Schedule> schedule =new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="class_id",referencedColumnName="class_id")
	private Class cls;

}
