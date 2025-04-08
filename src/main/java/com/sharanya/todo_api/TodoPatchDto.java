package com.sharanya.todo_api;

public class TodoPatchDto {
    private String title;
    private String description;
    private Boolean completed;

    // Getters and setters (Lombok also fine if you're using it)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
