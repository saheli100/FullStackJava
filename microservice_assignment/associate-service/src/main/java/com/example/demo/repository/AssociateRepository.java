package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Associate;

public interface AssociateRepository extends JpaRepository<Associate, Integer>{
	@Transactional
	@Modifying
	@Query("DELETE FROM Associate WHERE associate_id = :associateId")
	public Integer deleteByAssociateId(int associateId);

}
