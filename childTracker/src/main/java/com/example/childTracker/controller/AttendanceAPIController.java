package com.example.childTracker.controller;


import com.example.childTracker.model.CustodyTransfer;
import com.example.childTracker.model.Guardian;
import com.example.childTracker.model.Student;
import com.example.childTracker.model.Teacher;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AttendanceAPIController {

    public CustodyTransfer checkIn( Student student, Guardian guardian, Teacher teacher) throws Exception {
        String type;


        if (student.isCheckedIn()) {
            throw new Exception("Student is already checked in.");
        } else {
            //retrieve student, parent, and teacher
            //if checkedIn generate new custodyTransfer

            //else throw error back to client stating that student is already checked in.
            student.setCheckedIn(true);
            return new CustodyTransfer(student, guardian, teacher, "Check In");
        }
    }

    public CustodyTransfer checkOut(Student student, Guardian guardian, Teacher teacher) throws Exception {
        String type;


        if (!student.isCheckedIn()) {
            throw new Exception("Student is already checked out.");
        } else {
            //retrieve student, parent, and teacher
            //if checkedIn generate new custodyTransfer

            //else throw error back to client stating that student is already checked in.
            student.setCheckedIn(false);
            return new CustodyTransfer(student, guardian, teacher, "Check Out");
        }
    }
}
