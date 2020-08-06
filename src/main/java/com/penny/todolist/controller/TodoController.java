package com.penny.todolist.controller;

import com.penny.todolist.exception.NotFoundException;
import com.penny.todolist.model.Todo;
import com.penny.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getAllTodoList() {
        return todoService.getTodos();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping("/{TodoID}")
    @ResponseStatus(HttpStatus.OK)
    public Todo updateTodo(@PathVariable int TodoID, @RequestBody Todo todo) {
        return todoService.updateTodo(TodoID,todo);
    }

    @DeleteMapping("/{TodoID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTodo(@PathVariable int TodoID) throws NotFoundException {
        todoService.delete(TodoID);
    }
}
