package com.application.firststep.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.firststep.DTOs.*;
import com.application.firststep.model.User;
import com.application.firststep.model.UserProfile;
import com.application.firststep.repositories.ProfileRepository;
import com.application.firststep.repositories.UserRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public User saveUser(UserDto userDto) {
		
		User user = new User();
		
		String mobileNumber = userDto.getMobileNo();
		//String password = new BCryptPasswordEncoder().encode(userDto.getPassword());

		User existingUser = userRepository.findByMobileNumber(mobileNumber);

		if( existingUser == null ){	
			user.setMobileNumber(mobileNumber);
			user.setEmailId(userDto.getEmail());
			user.setFirstName(userDto.getFirstName());
			user.setLastName(userDto.getLastName());
			user.setUserName(userDto.getUserName());
			user.setPassword(userDto.getPassword());
			user.setUserId(userDto.getId());
			user.setCity(userDto.getCity());
			user.setCollege(userDto.getCollege());
			user.setRefferal_code(userDto.getRefferalCode());
			user.setUserProfile(null);
			
			user = userRepository.save(user);
			return user;
		}
		return null;
		
	}

	@Override
	public User loginUser(UserDto userDto) {		
		User existingUser = userRepository.findByMobileNumber(userDto.getMobileNo());
		if(existingUser == null) return null;
		if(existingUser.getPassword().equals(userDto.getPassword())) {
			existingUser.setUserProfile(null);
			return existingUser;
		}
		return null;
	}
	
	@Override
	public User changePassword(UserDto userDto) {
		
		User existingUser = userRepository.findByMobileNumber(userDto.getMobileNo());

		if(existingUser != null) {
			existingUser.setPassword(userDto.getPassword());
			existingUser = userRepository.save(existingUser);
			existingUser.setUserProfile(null);
			return existingUser;
		}
		return null;

	}
	
	//@SuppressWarnings("resource")
	@Override
	public UserProfile saveProfile(UserDto userDto) throws FileNotFoundException, IOException{
		
		User existingUser = userRepository.findByUserId(userDto.getId());

		if(existingUser != null) {
	
			UserProfile newProfile = new UserProfile();
			UserProfile existingProfile = existingUser.getUserProfile();
			
			if(existingProfile != null) newProfile.setId(existingProfile.getId());
			
			InputStream photo = new FileInputStream(userDto.getImage());
			photo.close();
			newProfile.setPhoto(photo.readAllBytes());
			
			newProfile.setUser(existingUser);
			
			profileRepository.save(newProfile);
			
			newProfile.setUser(null);
			return 	newProfile;
		}
		return null;
	}
	
}
