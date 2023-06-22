package com.example.demo.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Associate;
import com.example.demo.entity.Skill;
import com.example.demo.exception.MyCustomException;
import com.example.demo.service.AssociateService;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/associates")
@AllArgsConstructor
public class AssociateController {
	   private final AssociateService associateService;
	   private final RestTemplate restTemplate;
	   
	   @PostMapping
		public ResponseEntity<Associate> addAssociate(@RequestBody Associate associate) {
		   Skill skill=restTemplate.getForObject("http://localhost:8082/skill-service/skills/{associateId}", Skill.class, Map.of("associateId",associate.getSkillId()));
		   associate.setSkillName(skill.getSkillName());
		   return ResponseEntity.status(HttpStatus.CREATED).body(associateService.addAssociate(associate));
		}
	   @GetMapping
		public ResponseEntity<Iterable<Associate>> getAllSkillRecords() {
			return ResponseEntity.status(HttpStatus.OK).body(associateService.getAllAssociates());
		}
	   @GetMapping("/find/{id}")
		public ResponseEntity<Optional<Associate>> findByAssociateId(@PathVariable Integer id) {
		   Optional<Associate> findByAssociateId = associateService.findByAssociateId(id);
		   if(findByAssociateId.isEmpty()) {
			   throw new MyCustomException("Associate With id " + id + " nt found");}
		   else 
			return ResponseEntity.status(HttpStatus.OK).body(findByAssociateId);
		}
	   @GetMapping("/name/{associateName}")
		public ResponseEntity<Associate> findAssociateByName(@PathVariable("associateName") String associateName) {
			Associate findByName = associateService.findByName(associateName);
			return ResponseEntity.status(HttpStatus.OK).body(findByName);
		}
	   @GetMapping("/email/{email}")
		public ResponseEntity<Associate> findByEmail(@PathVariable String email) {
			return ResponseEntity.status(HttpStatus.OK).body(associateService.findByEmail(email));
		}
	   @GetMapping("/mobnum/{mobnum}")
		public ResponseEntity<Associate> findByMobNum(@PathVariable String mobnum) {
			return ResponseEntity.status(HttpStatus.OK).body(associateService.findByMobNum(mobnum));
		}
	   @GetMapping("/skill/{skills}")
		public ResponseEntity<Associate> findBySkills(@PathVariable String skills) {
			return ResponseEntity.status(HttpStatus.OK).body(associateService.findBySkills(skills));
		}
	   @DeleteMapping("/{id}")
		public void deleteByAssociateId(@PathVariable Integer id) {
			associateService.deleteByAssociateId(id);
		}
	   @DeleteMapping("/delete/{id}")
		public ResponseEntity<Integer> deleteById(@PathVariable Integer id) {
		   Integer idToDelete=associateService.deleteById(id);
		   if(idToDelete == null) {
			   throw new MyCustomException("Associate With id " + id + " nt found");}
		   else {
			   return ResponseEntity.status(HttpStatus.OK).body(idToDelete);}
		}

	   @PutMapping("/update/{id}")
		public ResponseEntity<Associate> updateUserById(@PathVariable("id") int id,
				@RequestBody Associate associate) {
		   Skill skill=restTemplate.getForObject("http://localhost:8082/skill-service/skills/{associateId}", Skill.class, Map.of("associateId",associate.getSkillId()));
		   associate.setSkillName(skill.getSkillName());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(associateService.updateAssociate(id, associate));
		}

}
