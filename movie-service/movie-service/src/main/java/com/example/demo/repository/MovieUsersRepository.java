package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.MovieUsers;

public interface MovieUsersRepository extends JpaRepository<MovieUsers, Long> {
    //Optional<MovieUsers> findByEmail(String email);
    Optional<MovieUsers> findByUsernameOrEmail(String username, String email);
    //Optional<MovieUsers> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
