package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AdminDTO;
import com.app.dto.AuthenticateDTO;
import com.app.dto.ForgotPasswordDTO;
import com.app.dto.UpdateUserDTO;
import com.app.dto.UserIdDTO;
import com.app.entities.User;
import com.app.repository.UserRepository;
import com.app.security.AES;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	
	
	@Autowired
	private UserRepository userRepo;
	
	AES a = new AES();

	@Override
	public User findByEmail(AuthenticateDTO auth) {
		try {
		User user = userRepo.findByEmail(auth.getEmail());
		final String secretKey = "ssshhhhhhhhhhh!!!!";
	    String userpass=user.getPassword();
		String password = AES.decrypt(userpass, secretKey);
		System.out.println(password);
		if(user!=null && password.equals(auth.getPassword())) {
			return user;
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public User updatePassword(ForgotPasswordDTO fpd) {
//		User user = userRepo.findByEmail(fpd.getEmail());
//		if(user.getSecurityCode()==fpd.getSecuritycode())
//		{
//			user.setPassword(fpd.getNewPassword());
//			userRepo.save(user);
//			return user;
//		}
//		return null;
//	}
	
	
	
	@Override
	public User updatePassword(ForgotPasswordDTO fpd) {
		User user = userRepo.findByEmail(fpd.getEmail());
		final String secretKey = "ssshhhhhhhhhhh!!!!";
		String password = AES.encrypt(fpd.getNewPassword(), secretKey);
		if(user.getSecurityCode()==fpd.getSecuritycode())
		{
			user.setPassword(password);
			userRepo.save(user);
			return user;
		}
		return null;
	}

	
	
	
	
	
	
	@Override
	public User addAdmin(AdminDTO admin) {
		try {
			final String secretKey = "ssshhhhhhhhhhh!!!!";
		String password = AES.encrypt(admin.getPassword(), secretKey);
		User newUser = new User();
		newUser.setFname(admin.getFname());
		newUser.setLname(admin.getLname());
		newUser.setEmail(admin.getEmail());
		newUser.setPassword(password);
		newUser.setAddressLine(admin.getAddressLine());
		newUser.setCity(admin.getCity());
		newUser.setPincode(admin.getPincode());
		newUser.setRole(admin.getRole());
		newUser.setSecurityCode(admin.getSecurityCode());
		userRepo.save(newUser);
		return newUser;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Optional<User> getUserById(UserIdDTO id) {
		Optional<User> user = userRepo.findById(id.getUserid());
		return user;
	}

	@Override
	public User updateUser(UpdateUserDTO user) {
		User u1 = userRepo.getById(user.getUserid());
		u1.setFname(user.getFname());
		u1.setLname(user.getLname());
		u1.setEmail(user.getEmail());
		u1.setPassword(user.getPassword());
		u1.setAddressLine(user.getAddressLine());
		u1.setCity(user.getCity());
		u1.setPincode(user.getPincode());
		u1.setRole(user.getRole());
		u1.setSecurityCode(user.getSecurityCode());
		userRepo.save(u1);
		return u1;
	}
	
	
	
	
	
	
	
	
	
	

}
