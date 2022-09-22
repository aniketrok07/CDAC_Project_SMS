package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_tbl")
@Getter
@Setter
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	@Column(name="first_name",length=20)
	private String fname;
	@Column(name="last_name",length=20)
	private String lname;
	@Column(length=30)
	private String email;
	@Column(length=30)
	private String password;
	@Column(name="address_line",length=30)
	private String addressLine;
	@Column(length=10)
	private String city;
	@Column(length=6)
	private String pincode;
	private int securityCode;
	@Column(length=10)
	private String role;
	
	
	

}
