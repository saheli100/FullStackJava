package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Associate;

public interface AssociateService {
	public Associate addAssociate(Associate associate);
	Iterable<Associate> getAllAssociates();

	public Optional<Associate> findByAssociateId(Integer associateId);
//	
	public Associate findByName(String name);
//	
	public Associate findByEmail(String email);
//	
	public Associate findByMobNum(String mobnum);
//	
	public Associate findBySkills(String skill);
//	
	public void deleteByAssociateId(Integer associateId);
	public Integer deleteById(Integer associateId);
//	
	public Associate updateAssociate(int associateId,Associate skill);
}
