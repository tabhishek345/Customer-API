package com.capg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capg.entity.UserData;
import com.capg.entity.UserDataDetails;
import com.capg.repository.UserRepository;
@Service
public class UserDataService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserData user=userRepository.findUserByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException(username+" doesn't exist" );
		
		return new UserDataDetails(user);
	}

}
