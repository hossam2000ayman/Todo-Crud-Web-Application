package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@CrossOrigin("*")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("add")
    public Todo addTask(@RequestBody Todo todo) {
        return todoService.addTask(todo);
    }

    @PutMapping("update/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo newTodo) {
        return todoService.updateTodo(id, newTodo);
    }

    @DeleteMapping("delete/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

    @DeleteMapping("destroy")
    public void destroyTodos(){
        todoService.destroyTodo();
    }

    @GetMapping("{id}")
    public Todo getTodo(@PathVariable Long id) {
        return todoService.getTodo(id);
    }


    @GetMapping
    public List<Todo> fetchAll() {
        return todoService.fetchAll();
    }

}
