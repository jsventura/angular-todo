package com.todo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.dao.TodoDao;
import com.todo.model.Todo;

@RestController
@RequestMapping("todos")
public class TodoController {
	
	@Autowired
	private TodoDao todoDao;
	
	//create
	@RequestMapping(method = RequestMethod.POST)
	public Todo saveTodo(@RequestBody Todo todo){
		return todoDao.save(todo);
	}
	
	//Read
	@RequestMapping(method = RequestMethod.GET)
	public List<Todo> getAllTodo(){
		return todoDao.findAll();
	}
	
	//Read
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public Todo getTodo(@PathVariable("id") int id){
		return todoDao.findById(id);
	}
	
	//Update
	@RequestMapping(method = RequestMethod.PUT)
	public Todo updateTodo(@RequestBody Todo todo){
		return todoDao.update(todo);
	}	
	
	//Delete
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	public Todo deleteTodo(@PathVariable("id") int id){
		return todoDao.deleteById(id);
	}	
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	@ResponseBody
	public String holaMundo(){
		return "Hola Mundo";
	}
}
