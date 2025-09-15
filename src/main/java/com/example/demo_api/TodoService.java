package com.example.demo_api;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void createTodo(String title) {
        todoRepository.save(new Todo(null, title));
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
}