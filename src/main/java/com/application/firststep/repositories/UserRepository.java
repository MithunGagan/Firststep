package com.application.firststep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.application.firststep.model.User;



public interface UserRepository extends JpaRepository<User, Long>{
	User findByMobileNumber(String mobileNumber);
	User findByEmailId(String email);
	User findByUserName(String userName);
	User findByUserId(Long id);
}
