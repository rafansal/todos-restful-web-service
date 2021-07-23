package com.todos.rest.webservices.todosrestfulwebservice.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.todos.rest.webservices.todosrestfulwebservice.entity.Todo;
import com.todos.rest.webservices.todosrestfulwebservice.services.TodoService;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class TodosController {
	
	@Autowired
	private TodoService todoService;

	@GetMapping("/user/{username}/todos")
	public List<Todo> getAllTodosForUser(@PathVariable String username){
		return todoService.findAll();
	}
	
	@GetMapping("/user/todo/{id}")
	public Todo getTodo(@PathVariable long id){
		return todoService.findById(id);
	}
	
//	@PutMapping("/user/todo/update/{id}")
//	public ResponseEntity<Todo> updateTodo(
//			@PathVariable long id, 
//			@RequestBody Todo todo){
//		Todo updatedTodo = todoService.save(todo);
//		return ResponseEntity<Todo>(todo,HttpStatus.OK);
//	}
	
	@PutMapping("/user/todo/{id}")
	public ResponseEntity<Todo> updateTodo(
			@PathVariable long id, 
			@RequestBody Todo todo){
		
		Todo todoUpdated = todoService.save(todo);
		
		return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
	}
	
	@PostMapping("/user/todo")
	public ResponseEntity<Void> saveTodo(@RequestBody Todo todo){
		
		Todo savedTodo = todoService.save(todo);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedTodo.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/user/todo/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable long id){
		Todo todo = todoService.delete(id);
		if(todo != null) 
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.notFound().build();
	}
	
}
