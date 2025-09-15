package com.example.demo_api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @BeforeEach
    void setup() { MockitoAnnotations.openMocks(this); }

    @Test
    void Todo追加でRepositoryが呼ばれること() {
        todoService.createTodo("Test Task");
        verify(todoRepository, times(1)).save(any(Todo.class));
    }

    @Test
    void Todo一覧を返すこと() {
        when(todoRepository.findAll()).thenReturn(List.of(new Todo(1, "Test Task")));
        List<Todo> todos = todoService.getAllTodos();
        assertThat(todos).hasSize(1).extracting(Todo::getTitle).contains("Test Task");
    }
}