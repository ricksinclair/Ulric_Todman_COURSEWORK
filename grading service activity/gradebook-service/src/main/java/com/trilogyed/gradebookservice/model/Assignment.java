package com.trilogyed.gradebookservice.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Assignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assignment_id;
    @NotNull
    @Size(max= 50)
    private String name;
    @NotNull
    @Size(max= 255)
    private String description;

    public Assignment(){

    }

    public Assignment(int assignment_id, @NotNull @Size(max = 50) String name, @NotNull @Size(max = 255) String description) {
        this.assignment_id = assignment_id;
        this.name = name;
        this.description = description;
    }

    public int getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(int assignment_id) {
        this.assignment_id = assignment_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return getAssignment_id() == that.getAssignment_id() &&
                getName().equals(that.getName()) &&
                getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAssignment_id(), getName(), getDescription());
    }

    @Override
    public String toString() {
        return "AssignmentRepository{" +
                "assignment_id=" + assignment_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
