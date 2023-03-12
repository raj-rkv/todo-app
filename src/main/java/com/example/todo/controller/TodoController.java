package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.ITodoService;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/todo-app")
public class TodoController {
    @Autowired
    private ITodoService todoService;

//    public TodoController(TodoService todoService)
//    {
//        this.todoService=todoService;
//    }
    @PostMapping("create-todo")
    public void createTodo(@RequestBody Todo todo)  //Request is for accepting whole object
    {
        todoService.addTodo(todo);  //Dependency injection ,we have never initiated the object SpringBoot automatically create the object
    }
    @GetMapping("/find-by-id/id/{id}")
    public Todo findTodoById(@PathVariable int id){
        return todoService.findById(id);
    }
    @GetMapping("find-all")
    public List<Todo> findAllTodo(){
        return todoService.findAll();
    }

    @PutMapping("/update-todo/id/{id}")
    public void updateTodo(@PathVariable int id,@RequestBody Todo todo){
        todoService.updateTodo(id,todo);
    }
    @DeleteMapping("delete-todo/id/{id}")
    public String deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
        return "Successfully Deleted";
    }

    @RequestMapping("/api")
    public String helloUser(@RequestParam String user){
        return "Hello "+user+" Welcome to todo App";
    }

//    @RequestMapping("/api/user/{user}")
//    public String helloUser(@PathVariable  String user)
//    {
//        return "Hello "+user;
//    }
}
