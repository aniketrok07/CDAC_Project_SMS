package com.app.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
	
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String addressLine;
	private String city;
	private String pincode;
	private String role;
	private int securityCode;
	private int classId;

}