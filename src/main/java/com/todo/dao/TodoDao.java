package com.todo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.todo.model.Todo;

@Service
@Transactional
public class TodoDao {
	
	@PersistenceContext
	EntityManager em;
	
	public Todo save(Todo todo){
		em.persist(todo);
		return todo;
	}
	
	public List<Todo> findAll(){
		Query query = em.createQuery("select t from Todo t");
		return query.getResultList();
	}
	
	public Todo findById(int id){
		return em.find(Todo.class, id);
	}
	
	
	public Todo update(Todo todo){
		Todo t = em.find(Todo.class, todo.getId());
		t.setName(todo.getName());
		return t;
	}
	
	public Todo deleteById(int id){
		Todo todo = em.find(Todo.class, id);
		if(todo != null){
			em.remove(todo);
		}
		return todo;
	}
}
