package com.penny.todolist.service;

import com.penny.todolist.model.Todo;
import com.penny.todolist.repository.TodoRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    public void should_return_Todo_when_post_Todo_given_Todo() {
        //given
        TodoRepository todoRepository = mock(TodoRepository.class);
        Todo todo = new Todo(1,"test1",false);
        given(todoRepository.save(todo)).willReturn(todo);
        //when
        TodoService todoService = new TodoService(todoRepository);
        Todo newtodo = todoService.addTodo(todo);
        //then
        assertEquals(newtodo, todo);
    }
}
