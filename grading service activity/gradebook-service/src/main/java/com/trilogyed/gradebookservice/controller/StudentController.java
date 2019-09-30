package com.trilogyed.gradebookservice.controller;

import com.trilogyed.gradebookservice.model.Student;
import com.trilogyed.gradebookservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Student addStudent(@Valid @RequestBody Student student){
        return studentRepository.save(student);
    }

    @RequestMapping(value = "/student/{studentId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Student getStudent(@PathVariable int studentId){
        return studentRepository.getOne(studentId);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateStudent(@Valid  @RequestBody Student student){

        Student studentUpdated = studentRepository.getOne(student.getStudentId());
        studentUpdated.setFirstName(student.getFirstName());
        studentUpdated.setLastName(student.getLastName());
        studentRepository.save(studentUpdated);
    }

    @RequestMapping(value = "/student/{studentId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable int studentId){
        studentRepository.deleteById(studentId);
    }
}


