package com.todos.rest.webservices.todosrestfulwebservice.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todos.rest.webservices.todosrestfulwebservice.entity.Todo;

@Service
public class TodoService {
	
	private long idCounter = 3;
	private static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(0, "rafansal", "To service the car", new Date(), true));
		todos.add(new Todo(1, "rafansal", "Learn to dance", new Date(), false));
		todos.add(new Todo(2, "rafansal", "Complete the react course", new Date(), false));
		todos.add(new Todo(3, "rafansal", "Pick up father from airport", new Date(), false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todo.setIsDone(false);
			todos.add(todo);
		}
		else {
			delete(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

	public Todo delete(long id) {
		Todo todo = findById(id);
		if(todo != null && todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Todo findById(long id) {
		for(Todo todo:todos) {
			if(todo.getId() == id)
				return todo;
		}
		return null;
	}

}
