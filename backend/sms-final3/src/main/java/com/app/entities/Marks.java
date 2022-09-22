package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString.Exclude;

@Entity
@Table(name="marks_tbl")
@Setter
@Getter
@NoArgsConstructor
public class Marks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="marks_id")
	private Integer marksId;
	private int marks;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="stud_id",referencedColumnName="student_id")
	private Student student;
	@Exclude
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="subject_id",referencedColumnName = "subject_id" )
	private Subject subject;

}
