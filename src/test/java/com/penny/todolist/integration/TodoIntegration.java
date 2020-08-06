package com.penny.todolist.integration;


import com.penny.todolist.model.Todo;
import com.penny.todolist.repository.TodoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoIntegration {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private MockMvc mockMvc;
    private int TodoId;

    @BeforeEach
    public void before() {
        Todo firstTodo = new Todo(1,"test1",false);
        Todo saveTodo = todoRepository.save(firstTodo);
        TodoId = saveTodo.getId();
    }

    @AfterEach
    public void after() {
        todoRepository.deleteAll();
    }

    @Test
    public void should_return_todos_when_get_todos_given_none() throws Exception {
        //when then
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(TodoId))
                .andExpect(jsonPath("$[0].content").value("test1"))
                .andExpect(jsonPath("$[0].status").value(false));
    }
}