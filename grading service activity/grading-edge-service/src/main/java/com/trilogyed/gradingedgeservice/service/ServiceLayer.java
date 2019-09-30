package com.trilogyed.gradingedgeservice.service;

import com.trilogyed.gradingedgeservice.model.Student;
import com.trilogyed.gradingedgeservice.util.feign.AssignmentFeignClient;
import com.trilogyed.gradingedgeservice.util.feign.GradeFeignClient;
import com.trilogyed.gradingedgeservice.util.feign.StudentFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceLayer {

    @Autowired
    AssignmentFeignClient assignmentFeignClient;

    @Autowired
    GradeFeignClient gradeFeignClient;

    @Autowired
    StudentFeignClient studentFeignClient;

    public ServiceLayer(){

    }

    public ServiceLayer(AssignmentFeignClient assignmentFeignClient, GradeFeignClient gradeFeignClient, StudentFeignClient studentFeignClient) {
        this.assignmentFeignClient = assignmentFeignClient;
        this.gradeFeignClient = gradeFeignClient;
        this.studentFeignClient = studentFeignClient;
    }


    public Student addStudent(Student student){
        return studentFeignClient.addStudent(student);
    }

    public Student getStudent(int id){
        return studentFeignClient.getStudentById(id);
    }

    public void updateStudent(Student student) {
        if (student.getStudentId() == 0) {
            throw new IllegalArgumentException("must include a student with a valid student id");
        } else {

            studentFeignClient.addStudent(student);
        }
    }

    public void deleteStudent(int id){
        studentFeignClient.deleteStudentById(id);
    }


    public List<Student> getAllStudents(){
        return studentFeignClient.getAllStudents();
    }



}
