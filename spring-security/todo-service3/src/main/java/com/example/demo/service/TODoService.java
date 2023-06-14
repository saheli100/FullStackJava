package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.ToDo;

public interface TODoService {
	
	public ToDo createToDo(ToDo toDo);
	
	public ToDo updateToDo(int id, ToDo toDo);
	
	public  Iterable<ToDo> fetchAllToDos();
	
	public   Optional<ToDo> getTodoById(int id);
	
	public   void deleteTodoById(int id);

}