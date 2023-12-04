package com.example.todo.service;

import com.example.todo.TodoApplication;
import com.example.todo.model.Todo;

import java.util.List;

public interface TodoService {


    Todo addTask(Todo todo);

    Todo updateTodo(Long id, Todo newTodo);

    void deleteTodo(Long id);

    void destroyTodo();

    Todo getTodo(Long id);

    List<Todo> fetchAll();
}
