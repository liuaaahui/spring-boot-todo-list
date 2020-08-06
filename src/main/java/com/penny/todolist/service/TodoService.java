package com.penny.todolist.service;

import com.penny.todolist.model.Todo;
import com.penny.todolist.repository.TodoRepository;

import java.util.List;

public class TodoService {
    private TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }
}
