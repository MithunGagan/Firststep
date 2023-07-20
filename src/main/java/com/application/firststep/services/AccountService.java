package com.application.firststep.services;


import java.io.FileNotFoundException;
import java.io.IOException;

import com.application.firststep.DTOs.*;
import com.application.firststep.model.*;

public interface AccountService {

	User saveUser(UserDto userDto);
	User changePassword(UserDto userDto);
	User loginUser(UserDto userDto);
	UserProfile saveProfile(UserDto userDto) throws FileNotFoundException, IOException;
	UserProfile updateProfile(UserDto userDto) throws FileNotFoundException, IOException;
}
