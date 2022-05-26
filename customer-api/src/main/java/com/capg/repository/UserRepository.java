package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.UserData;

public interface UserRepository extends JpaRepository<UserData, Integer> {
	
	UserData findUserByUsername(String username); 

}
