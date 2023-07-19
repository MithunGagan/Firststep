package com.application.firststep.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.application.firststep.DTOs.*;
import com.application.firststep.model.*;
import com.application.firststep.services.AccountService;

@RestController
public class UserController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/signup")
	//@Consumes(MediaType.APPLICATION_XML)
	public ResponseEntity<Object> signup( @RequestBody UserDto userDto) {
		User savedUser = null;
		
		if (userDto == null)
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Please provide required fields",
					savedUser);
		if (userDto.getMobileNo() == null )
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Mobile Number cannot be empty",
					savedUser);

		savedUser = accountService.saveUser(userDto);

		if (savedUser != null) {
			return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "User Successully Signedup", savedUser);
		}
		return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false,
				"User Already Exists Please Provide Different Mobile number", savedUser);

	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserDto userDto) {

		if (userDto == null || userDto.getMobileNo() == null ) {
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Mobile Number cannot be empty",
					userDto);
		}

		User loggedInUser = accountService.loginUser(userDto);

		if (loggedInUser != null) {
			return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, true, "Logged In successfuly", loggedInUser);
		}
		return ResponseHandler.generateResponse(HttpStatus.CONFLICT, false, "Mobile Number or Password is wrong", loggedInUser);
	}

	@PostMapping("/changePassword")
	public ResponseEntity<Object> changePassword(@RequestBody UserDto userDto) {

		if (userDto == null || userDto.getMobileNo() == null) {
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Mobile Number or Password cannot be empty",
					userDto);
		}

		User changedPassword = accountService.changePassword(userDto);

		if (changedPassword != null) {
			return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, true, "Password changed successfully",
					changedPassword);
		}
		return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Mobile  Number does not exist",
				changedPassword);

	}
	
	@PostMapping("/profile")
	public ResponseEntity<Object> profile(@RequestBody UserDto userDto) throws IOException {
		
		UserProfile updatedProfile = accountService.saveProfile(userDto);
		
		if(updatedProfile != null) {
			return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, true, "Profile Picture Updated Successfully", updatedProfile);
		}
		return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "User does not exits or Improper Image Format", updatedProfile);
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}

}
