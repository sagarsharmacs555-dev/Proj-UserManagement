package com.app.example.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.example.entity.UserEntity;
import com.app.example.repo.UserRepo;

@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	public UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserEntity> user = userRepo.findByUsername(username);
		
		if(user.isPresent())
		{
				var u1 = user.get();
			
			return User.builder().username(u1.getUsername())
						.password(u1.getPassword())
						.roles(u1.getRole())
						.build();
			
		}
		
		else { throw new UsernameNotFoundException(username);}
	}
	

}
