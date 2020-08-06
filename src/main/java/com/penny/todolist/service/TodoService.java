package com.penny.todolist.service;

import com.penny.todolist.exception.NotFoundException;
import com.penny.todolist.model.Todo;
import com.penny.todolist.repository.TodoRepository;

import java.util.List;

public class TodoService {
    private static final String DO_NOT_FIND_THIS_TODO = "do not find this todo";

    private final TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo findTodoById(int id) throws NotFoundException {
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo == null){
            throw new NotFoundException(DO_NOT_FIND_THIS_TODO);
        }
        return todo;
    }

    public Todo updateTodo(int id, Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(int id) throws NotFoundException {
        findTodoById(id);
        todoRepository.deleteById(id);
    }
}
