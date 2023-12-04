package com.example.todo.service.serviceImplementation;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.TodoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodoServiceImplementation implements TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo addTask(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, Todo newTodo) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo not Found"));
        todo.setTask(newTodo.getTask());
        todo.setDate(LocalDate.now());
        todo.setIsDone(newTodo.getIsDone());
        todo.setDescription(newTodo.getDescription());
        return todoRepository.saveAndFlush(newTodo);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo not Found"));
        todoRepository.deleteById(id);
    }

    @Override
    public void destroyTodo() {
        todoRepository.deleteAll();
    }

    @Override
    public Todo getTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo not Found"));
    }

    @Override
    public List<Todo> fetchAll() {
        return todoRepository.findAll();
    }
}
