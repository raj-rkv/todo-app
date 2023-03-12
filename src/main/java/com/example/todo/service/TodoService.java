package com.example.todo.service;

import com.example.todo.TodoApplication;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService implements ITodoService{
    private static List<Todo> todos=new ArrayList<>();  //In-memory database

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todo> findAll(){

        return todoRepository.findAll();
    }
    @Override
    public Todo findById(int id)
    {
        return todoRepository.findById(id).get();
    }
    @Override
    public void addTodo(Todo todo)
    {
        todoRepository.save(todo);
    }
    @Override
    public void deleteTodo(int id)
    {
        todoRepository.deleteById(id);
    }
    @Override
    public void updateTodo(int id,Todo newtodo)
    {

            Todo todo = todoRepository.findById(id).get();
            todo.setId(newtodo.getId());
            todo.setTittle(newtodo.getTittle());
            todo.setStatus(newtodo.isStatus());
            todoRepository.save(todo);

    }
}
