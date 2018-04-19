package com.setyo.helloworld.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.setyo.helloworld.model.Todo;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount = 3;
	
	static {
		todos.add(new Todo(1,"Tya","Washing dishes", new Date(), false));
		todos.add(new Todo(2,"Tya","Watering the flowers", new Date(),false));
		todos.add(new Todo(3,"Tya","Cooking",new Date(),false));	
	}
	
	public Todo addTodo(String name, String desc, Date date, Boolean isDone) {
		Todo todo = new Todo(++todoCount,name, desc, date, isDone);
		todos.add(todo);
		return todo;
	}
	
	public Todo retrieveTodo(int todoID) {
		for (Todo todo : todos) {
			if(todo.getId()==todoID) {
				return todo;
			}
		}
		return null;
	}
	
	public ArrayList<Todo> getAllTodo(){
		ArrayList<Todo> tempTodos = new ArrayList<>();
		tempTodos.addAll(todos);
		return tempTodos;
	}
}
