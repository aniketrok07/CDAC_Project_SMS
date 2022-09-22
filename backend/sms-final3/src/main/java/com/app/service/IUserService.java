package com.app.service;

import java.util.Optional;

import com.app.dto.AdminDTO;
import com.app.dto.AuthenticateDTO;
import com.app.dto.ForgotPasswordDTO;
import com.app.dto.UpdateUserDTO;
import com.app.dto.UserIdDTO;
import com.app.entities.User;

public interface IUserService {
	
	User findByEmail(AuthenticateDTO auth);
	
	User updatePassword(ForgotPasswordDTO fpd);
	
	User addAdmin(AdminDTO admin);
	
	Optional<User> getUserById(UserIdDTO id);
	
	User updateUser(UpdateUserDTO user);

}
