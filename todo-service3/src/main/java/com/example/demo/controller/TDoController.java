package com.example.demo.controller;

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

import com.example.demo.model.ToDo;
import com.example.demo.service.TODoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class TDoController {

	private final TODoService toDoService;

	@PostMapping
	public ResponseEntity<ToDo> createTODo(@RequestBody ToDo toDo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.createToDo(toDo));
	}
	@PutMapping("/{id}")
	public ResponseEntity<ToDo> updateTODo(@PathVariable int id, @RequestBody ToDo toDo) {
		return ResponseEntity.status(HttpStatus.OK).body(toDoService.updateToDo(id, toDo));
	}

	@GetMapping
	public ResponseEntity<Iterable<ToDo>> getAllToDos() {
		return ResponseEntity.status(HttpStatus.OK).body(toDoService.fetchAllToDos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ToDo>> getToDoById(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.FOUND).body(toDoService.getTodoById(id));
	}
	
	@DeleteMapping("/{id}")
	public String deleteToDoById(@PathVariable int id) {
		toDoService.deleteTodoById(id);
		return "Todo Id "+id+" is deleted";
	}
}