package com.example.demo.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MovieUsers;
import com.example.demo.repository.MovieUsersRepository;

@Service
public class MovieUserDetailsService implements UserDetailsService {

	private MovieUsersRepository movieUsersRepository;

	public MovieUserDetailsService(MovieUsersRepository movieUsersRepository) {
		this.movieUsersRepository = movieUsersRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		MovieUsers movieUsers = movieUsersRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(
				() -> new UsernameNotFoundException("User not found with username or email: " + usernameOrEmail));

		Set<GrantedAuthority> authorities = movieUsers.getRoles().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

		return new org.springframework.security.core.userdetails.User(movieUsers.getEmail(), movieUsers.getPassword(), authorities);
	}
	
	
}