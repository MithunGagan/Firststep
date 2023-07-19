package com.application.firststep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.application.firststep.model.UserProfile;



public interface ProfileRepository extends JpaRepository<UserProfile, Long> {

	
	
}
