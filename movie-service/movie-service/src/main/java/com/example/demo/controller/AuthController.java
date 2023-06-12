package com.example.demo.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.Movie;
import com.example.demo.entity.MovieUsers;
import com.example.demo.entity.Role;
import com.example.demo.repository.MovieUsersRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.MovieService;

import lombok.AllArgsConstructor;
//@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MovieUsersRepository movieUsersRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
 

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto,@RequestParam("roleName") String roleName){

        // add check for username exists in a DB
        if(movieUsersRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(movieUsersRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        MovieUsers movieUsers = new MovieUsers();
        movieUsers.setName(signUpDto.getName());
        movieUsers.setUsername(signUpDto.getUsername());
        movieUsers.setEmail(signUpDto.getEmail());
        movieUsers.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles = roleRepository.findByName(roleName).get();
        movieUsers.setRoles(Collections.singleton(roles));

        movieUsersRepository.save(movieUsers);

        return new ResponseEntity<>("MovieUser registered successfully", HttpStatus.OK);

    }
//    private final MovieService movieService;
//	   @PostMapping("/movies")
//		public ResponseEntity<Movie> createTODo(@RequestBody Movie movie) {
//			return ResponseEntity.status(HttpStatus.CREATED).body(movieService.addMovie(movie));
//		}
    
}
