package com.application.firststep.appsecurity;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.application.firststep.model.User;
import com.application.firststep.repositories.UserRepository;

public class UserDetailsServiceInfo implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User existingUser = userRepository.findByUserName(userName);
		
		if(existingUser != null) return new UserDetailsInfo(existingUser);
		
		throw new UsernameNotFoundException("User Doesnot Exist");
	
	}

}
*/