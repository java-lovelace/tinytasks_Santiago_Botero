package com.crudzaso.tinytasks.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Todo {

    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 3, message = "Title must be at least 3 characters long")
    private String title;

    private boolean done = false;

    public Todo(String title) {
        this.title = title;
    }


    public Todo(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    // Método utilitario opcional
    public void toggle() {
        this.done = !this.done;
    }
}
