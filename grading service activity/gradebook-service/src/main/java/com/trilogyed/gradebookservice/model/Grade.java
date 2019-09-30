package com.trilogyed.gradebookservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Grade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private int studentId;
    @NotNull
    private int assignmentId;
    @NotNull
    private int percentGrade;

    public Grade() {
    }

    public Grade(int id, @NotNull int studentId, @NotNull int assignmentId, @NotNull int percentGrade) {
        this.id = id;
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.percentGrade = percentGrade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getPercentGrade() {
        return percentGrade;
    }

    public void setPercentGrade(int percentGrade) {
        this.percentGrade = percentGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return getId() == grade.getId() &&
                getStudentId() == grade.getStudentId() &&
                getAssignmentId() == grade.getAssignmentId() &&
                getPercentGrade() == grade.getPercentGrade();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStudentId(), getAssignmentId(), getPercentGrade());
    }



}
