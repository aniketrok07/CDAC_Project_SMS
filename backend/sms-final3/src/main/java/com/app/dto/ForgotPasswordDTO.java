package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForgotPasswordDTO {
	
	private String email;
	private int securitycode;
	private String newPassword;

}
