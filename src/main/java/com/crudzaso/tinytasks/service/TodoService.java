package com.crudzaso.tinytasks.service;

import com.crudzaso.tinytasks.model.Todo;
import com.crudzaso.tinytasks.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getAll() {
        return repository.findAll();
    }

    public Todo create(String title) {
        if (title == null || title.trim().length() < 3) {
            throw new IllegalArgumentException("Title is required and must be at least 3 characters long.");
        }

        Todo todo = new Todo(title.trim());
        return repository.save(todo);
    }

    public Optional<Todo> toggle(Long id) {
        Optional<Todo> optionalTodo = repository.findById(id);

        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setDone(!todo.isDone());
            repository.save(todo);
            return Optional.of(todo);
        }

        return Optional.empty();
    }

    public boolean delete(Long id) {
        return repository.delete(id);
    }
}
