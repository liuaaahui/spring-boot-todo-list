package com.penny.todolist.service;

import com.penny.todolist.model.Todo;
import com.penny.todolist.repository.TodoRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class TodoServiceTest {
    @Test
    public void should_return_Todos_when_get_Todos_given_none() {
        //given
        TodoRepository todoRepository = mock(TodoRepository.class);
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo(1,"test1",false));
        todos.add(new Todo(2,"test2",false));
        given(todoRepository.findAll()).willReturn(todos);
        //when
        TodoService todoService = new TodoService(todoRepository);
        List<Todo> todoList = todoService.getTodos();
        //then
        assertIterableEquals(todoList, todos);
    }
}
