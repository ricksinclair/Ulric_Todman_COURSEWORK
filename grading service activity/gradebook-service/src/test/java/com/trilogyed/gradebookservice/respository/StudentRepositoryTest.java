package com.trilogyed.gradebookservice.respository;

import com.trilogyed.gradebookservice.model.Student;
import com.trilogyed.gradebookservice.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Before
    public void setUp() throws Exception{
        List<Student> studentList = studentRepository.findAll();

        studentList.forEach(student -> {
            studentRepository.deleteById(student.getStudentId());
        });
    }


    @Test
    public void addGetDeleteStudent(){
        Student testStudent1 = new Student();
        testStudent1.setFirstName("John");
        testStudent1.setLastName("Doe");
        studentRepository.save(testStudent1);
        Student testStudent1Retrieved;
        testStudent1Retrieved = studentRepository.findById(testStudent1.getStudentId());
        assertEquals(testStudent1, testStudent1Retrieved);

        studentRepository.deleteById(testStudent1.getStudentId());

        testStudent1Retrieved = studentRepository.findById(testStudent1.getStudentId());
        assertNull(testStudent1Retrieved);

    }

    @Test
    public void findAllStudents(){

        Student testStudent1 = new Student();
        testStudent1.setFirstName("John");
        testStudent1.setLastName("Doe");
        studentRepository.save(testStudent1);

        Student testStudent2 = new Student();
        testStudent2.setFirstName("Jane");
        testStudent2.setLastName("Doe");
        studentRepository.save(testStudent2);

        List<Student> studentList = studentRepository.findAll();

        assertEquals(2, studentList.size());
    }

    @Test
    public void updateStudent(){

        Student testStudent1 = new Student();
        testStudent1.setFirstName("John");
        testStudent1.setLastName("Doe");
        studentRepository.save(testStudent1);

        testStudent1.setLastName("Dough");

        studentRepository.save(testStudent1);

        Student testStudent1Updated = studentRepository.findById(testStudent1.getStudentId());

        assertEquals(testStudent1Updated.getLastName(), "Dough");
    }

}
