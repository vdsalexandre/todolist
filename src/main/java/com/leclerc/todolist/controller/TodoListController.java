package com.leclerc.todolist.controller;

import com.leclerc.todolist.model.Todo;
import com.leclerc.todolist.todoservice.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoListController {
    private final TodoServiceImpl service;

    @Autowired
    public TodoListController(TodoServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity home() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public Todo getTodo(@PathVariable(name = "id") Long id) {
        Optional<Todo> todo = service.findTodoById(id);
        return todo.isPresent() ? todo.get() : null;
    }

    @GetMapping("/find/all")
    public List<Todo> getAllTodo() {
        return service.findAllTodo();
    }

    @PutMapping("/add/{name}")
    public ResponseEntity addTodo(@PathVariable(name = "name") String name) {
        Todo todo = service.addNewTodo(name);
        System.out.println(todo);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity delTodo(@PathVariable(name = "id") Long id) {
        service.deleteTodo(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/update/{id}/{name}")
    public ResponseEntity updateTodo(@PathVariable(name = "id") Long id, @PathVariable(name = "name") String newName) {
        Todo todo = service.findTodoById(id).get();
        todo.setName(newName);
        service.updateTodo(todo);
        return new ResponseEntity(HttpStatus.OK);
    }
}
