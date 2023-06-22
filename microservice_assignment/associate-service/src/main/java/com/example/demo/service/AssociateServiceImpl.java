package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Associate;
import com.example.demo.repository.AssociateRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AssociateServiceImpl implements AssociateService {
	private final AssociateRepository associateRepository;

	@Override
	public Associate addAssociate(Associate associate) {
		// TODO Auto-generated method stub
		return associateRepository.save(associate);
	}

	@Override
	public Iterable<Associate> getAllAssociates() {
		// TODO Auto-generated method stub
		return associateRepository.findAll();
	}

	@Override
	public Optional<Associate> findByAssociateId(Integer associateId) {
		// TODO Auto-generated method stub
		return associateRepository.findById(associateId);
	}

	@Override
	public Associate findByName(String name) {
		// TODO Auto-generated method stub
		Associate associate = null;
		Iterable<Associate> associateList = getAllAssociates();
		for (Associate a : associateList) {
			if (a.getAssociateName().equals(name)) {
				System.out.println(a.getAssociateName());
				associate = a;

				break;
			}
		}
		return associate;
	}

//
	@Override
	public Associate findByEmail(String email) {
		// TODO Auto-generated method stub
		Associate associate = null;
		Iterable<Associate> associateList = getAllAssociates();
		for (Associate a : associateList) {
			if (a.getEmail().equals(email)) {
				associate = a;

				break;
			}
		}
		return associate;
	}

//	@Override
	public Associate findByMobNum(String mobnum) {
		// TODO Auto-generated method stub
		Associate associate = null;
		Iterable<Associate> associateList = getAllAssociates();
		for (Associate a : associateList) {
			if (a.getMobNumber().equals(mobnum)) {
				associate = a;

				break;
			}
		}
		return associate;
	}

//
	@Override
	public Associate findBySkills(String skill) {
		// TODO Auto-generated method stub
		Associate associate = null;
		Iterable<Associate> associateList = getAllAssociates();
		for (Associate a : associateList) {
			if (a.getSkillName().equals(skill)) {
				associate = a;

				break;
			}
		}
		return associate;
	}

//
	@Override
	public void deleteByAssociateId(Integer associateId) {
		associateRepository.deleteByAssociateId(associateId);

	}

	@Override
	public Integer deleteById(Integer associateId) {
		// TODO Auto-generated method stub
		return associateRepository.deleteByAssociateId(associateId);
	}

//
	@Override
	public Associate updateAssociate(int associateId, Associate associate) {
		// TODO Auto-generated method stub
		return associateRepository.save(associate);
	}
}
