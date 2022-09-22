package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="schedule_tbl")
@Getter
@Setter
@NoArgsConstructor
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="schedule_id")
	private Integer scheduleId;
	@Column(length=20)
	private String day;
	private int starttime;
	private int endtime;
	@ManyToOne
	@JoinColumn(name="subject_id",referencedColumnName="subject_id")
	private Subject subject;

}
