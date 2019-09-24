package com.trilogyed.tasker.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class Task {

    private int id;
    @NotNull(message = "Must include description")
    @Size(min = 0, max = 255)
    private String description;
    @NotNull(message = "Must include createDate")
    private LocalDate createDate;
    @NotNull(message = "Must include dueDate")
    private LocalDate dueDate;
    @NotNull(message = "Must include category")
    @Size(min = 0, max = 50)
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(description, task.description) &&
                Objects.equals(createDate, task.createDate) &&
                Objects.equals(dueDate, task.dueDate) &&
                Objects.equals(category, task.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createDate, dueDate, category);
    }
}
