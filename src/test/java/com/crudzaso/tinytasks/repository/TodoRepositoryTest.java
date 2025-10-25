package com.crudzaso.tinytasks.repository;

import com.crudzaso.tinytasks.model.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoRepositoryTest {

    private TodoRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TodoRepository();
    }

    @Test
    void testSaveGeneratesIncrementalId() {
        Todo t1 = repository.save(new Todo("Task 1"));
        Todo t2 = repository.save(new Todo("Task 2"));

        assertEquals(1L, t1.getId());
        assertEquals(2L, t2.getId());
    }

    @Test
    void testFindByIdReturnsTodo() {
        Todo saved = repository.save(new Todo("Task"));
        Optional<Todo> found = repository.findById(saved.getId());

        assertTrue(found.isPresent());
        assertEquals("Task", found.get().getTitle());
    }

    @Test
    void testFindByIdReturnsEmptyForNonExisting() {
        Optional<Todo> found = repository.findById(99L);
        assertFalse(found.isPresent());
    }

    @Test
    void testDeleteRemovesTodo() {
        Todo saved = repository.save(new Todo("To delete"));
        boolean deleted = repository.delete(saved.getId());

        assertTrue(deleted);
        assertTrue(repository.findAll().isEmpty());
    }

    @Test
    void testDeleteNonExistingReturnsFalse() {
        assertFalse(repository.delete(123L));
    }
}
