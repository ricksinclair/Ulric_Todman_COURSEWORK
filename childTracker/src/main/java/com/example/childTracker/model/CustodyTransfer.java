package com.example.childTracker.model;

import java.util.Date;

public class CustodyTransfer {

    private int transferId;
    private Date date;
    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private int guardianId;
    private String guardianFirstName;
    private String guardianLastName;
    private int teacherId;
    private String teacherFirstName;
    private String teacherLastName;
    private String type;

    public CustodyTransfer() {
    }

    public CustodyTransfer( Student student, Guardian guardian, Teacher teacher, String type) {
        this.date = new Date();
        this.studentId = student.getStudentId();
        this.studentFirstName = student.getFirstName();
        this.studentLastName = student.getLastName();
        this.guardianId = guardian.getGuardianId();
        this.guardianFirstName = guardian.getFirstName();
        this.guardianLastName = guardian.getLastName();
        this.teacherId = teacher.getTeacherId();
        this.teacherFirstName = teacher.getFirstName();
        this.teacherLastName = teacher.getLastName();
        this.type = type;
    }

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public Date getDate() {
        return date;
    }


    public int getStudentId() {
        return studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public int getGuardianId() {
        return guardianId;
    }

    public String getGuardianFirstName() {
        return guardianFirstName;
    }

    public String getGuardianLastName() {
        return guardianLastName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public String getType() {
        return type;
    }

}
