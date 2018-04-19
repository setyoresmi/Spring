package com.setyo.helloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.setyo.helloworld.model.Todo;
import com.setyo.helloworld.service.TodoService;

@RestController
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@GetMapping(path="/todos")
	public List<Todo> retrieveTodos(){
		return todoService.getAllTodo();
	}

	@PostMapping(path="/users/{name}/todo",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> add(@PathVariable String name, @RequestBody Todo todo){
		Todo createdTodo = todoService.addTodo(todo.getUser(), todo.getDesc(), todo.getTargetDate(), todo.isDone());
		if(createdTodo == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.accepted().build();
	}
	
}
