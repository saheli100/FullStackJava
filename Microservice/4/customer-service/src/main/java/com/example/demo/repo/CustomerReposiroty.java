package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Customer;

public interface CustomerReposiroty extends JpaRepository<Customer, Integer>{

}