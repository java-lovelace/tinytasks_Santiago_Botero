package com.crudzaso.tinytasks.service;

import com.crudzaso.tinytasks.model.Todo;
import com.crudzaso.tinytasks.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TodoServiceTest {

    private TodoService service;

    @BeforeEach
    void setUp() {
        service = new TodoService(new TodoRepository());
    }

    @Test
    void testCreateValidTodo() {
        Todo todo = service.create("New Task");
        assertNotNull(todo.getId());
        assertEquals("New Task", todo.getTitle());
        assertFalse(todo.isDone());
    }

    @Test
    void testCreateInvalidTodoThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.create(""));
        assertThrows(IllegalArgumentException.class, () -> service.create("ab"));
    }

    @Test
    void testToggleTodoChangesState() {
        Todo todo = service.create("Toggle Test");
        Long id = todo.getId();

        Optional<Todo> toggled = service.toggle(id);
        assertTrue(toggled.isPresent());
        assertTrue(toggled.get().isDone());
    }

    @Test
    void testToggleNonExistingReturnsEmpty() {
        Optional<Todo> result = service.toggle(999L);
        assertTrue(result.isEmpty());
    }

    @Test
    void testDeleteExistingTodo() {
        Todo todo = service.create("Delete me");
        boolean deleted = service.delete(todo.getId());
        assertTrue(deleted);
    }

    @Test
    void testDeleteNonExistingTodoReturnsFalse() {
        assertFalse(service.delete(100L));
    }
}
