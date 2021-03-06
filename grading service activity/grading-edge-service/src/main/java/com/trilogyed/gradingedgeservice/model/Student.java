package com.trilogyed.gradingedgeservice.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {

    private int studentId;
    @NotNull
    @Size(max = 50)
    private String firstName;
    @NotNull
    @Size(max = 50)
    private String lastName;

    public Student(){

    }

    public Student(int studentId, @NotNull @Size(max = 50) String firstName, @NotNull @Size(max = 50) String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getStudentId() == student.getStudentId() &&
                getFirstName().equals(student.getFirstName()) &&
                getLastName().equals(student.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return "StudentRepository{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
