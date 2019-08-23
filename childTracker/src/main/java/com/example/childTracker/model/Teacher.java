package com.example.childTracker.model;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int teacherId;
    private String firstName;
    private String lastName;
    private List<Student> studentList = new ArrayList<Student>();
    private List<Guardian> guardianList = new ArrayList<Guardian>();
    private String roomNumber;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String roomNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.roomNumber = roomNumber;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Guardian> getGuardianList() {
        return guardianList;
    }

    public void setGuardianList(List<Guardian> guardianList) {
        this.guardianList = guardianList;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
