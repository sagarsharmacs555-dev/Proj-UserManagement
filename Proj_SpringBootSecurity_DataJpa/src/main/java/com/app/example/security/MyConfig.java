package com.app.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MyConfig {
//	
//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		UserDetails user1 = User.builder()
//							.username("SagarSharma")
//							.password(passEncoder().encode("bhanu765"))
//							.roles("admin")
//							.build();
//		
//		UserDetails user2 = User.builder()
//				.username("BhanuSharma")
//				.password(passEncoder().encode("Bhanu765!"))
//				.roles("user")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user1,user2);
//
//	}

	@Bean
	public PasswordEncoder passEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.csrf(csrf -> csrf.disable())
		
					.authorizeHttpRequests(auth -> auth
					.requestMatchers("/home/**","/insert/**").permitAll()
					.requestMatchers("/admin/**").hasRole("admin")
					.requestMatchers("/user/**").hasAnyRole("user","admin")
					
				)
				
			
			.formLogin(Customizer.withDefaults());
				
		return httpSecurity.build();
	}
	

}
