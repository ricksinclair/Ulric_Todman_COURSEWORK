package com.example.childTracker.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {

    private int studentId;
    private String firstName;
    private String lastName;
    private List<Guardian> guardianList = new ArrayList<Guardian>();
    private List<Teacher> teacherList = new ArrayList<Teacher>();
    private String roomNumber;
    private Integer age;
    private String dateOfBirth;
    private List<String> allergies = new ArrayList<String>();
    private Map<String, String> medications = new HashMap<String, String>(); //MEDICATION IS FIRST STRING, DESCRIPTION OF REGIMEN IS SECOND.
    private boolean checkedIn;
    public Student() {

    }

    public Student(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
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

    public List<Guardian> getGuardianList() {
        return guardianList;
    }

    public void setGuardianList(List<Guardian> guardianList) {
        this.guardianList = guardianList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public Map<String, String> getMedications() {
        return medications;
    }

    public void setMedications(Map<String, String> medications) {
        this.medications = medications;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
