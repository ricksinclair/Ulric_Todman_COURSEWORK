package com.example.childTracker.model;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private int classId;
    private List<Student> studentList = new ArrayList<Student>();
    private List<Teacher> teacherList = new ArrayList<Teacher>();
    private String roomNumber;
    private List<CustodyTransfer> attendanceLog = new ArrayList<CustodyTransfer>();

    public Classroom() {

    }

    public Classroom(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
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

    public List<CustodyTransfer> getAttendanceLog() {
        return attendanceLog;
    }

    public void setAttendanceLog(List<CustodyTransfer> attendanceLog) {
        this.attendanceLog = attendanceLog;
    }
}
