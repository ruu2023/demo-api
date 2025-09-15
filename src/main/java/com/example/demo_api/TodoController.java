package com.example.demo_api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/todos")
public class TodoController {
    
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public void createTodo(@RequestBody Todo todo) {
        todoService.createTodo(todo.getTitle());
    }
    
    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getAllTodos();
    }
}
