package com.crudzaso.tinytasks.repository;

import com.crudzaso.tinytasks.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TodoRepository {

    private final Map<Long, Todo> todos = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public List<Todo> findAll() {
        return new ArrayList<>(todos.values());
    }

    public Optional<Todo> findById(Long id) {
        return Optional.ofNullable(todos.get(id));
    }

    public Todo save(Todo todo) {
        if (todo.getId() == null) {
            todo.setId(idCounter.incrementAndGet());
        }
        todos.put(todo.getId(), todo);
        return todo;
    }

    public boolean delete(Long id) {
        return todos.remove(id) != null;
    }

    public void clear() {
        todos.clear();
        idCounter.set(0);
    }
}
