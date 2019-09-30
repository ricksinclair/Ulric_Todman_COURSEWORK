package com.trilogyed.gradebookservice.respository;


import com.trilogyed.gradebookservice.model.Assignment;
import com.trilogyed.gradebookservice.model.Grade;
import com.trilogyed.gradebookservice.model.Student;
import com.trilogyed.gradebookservice.repository.AssignmentRepository;
import com.trilogyed.gradebookservice.repository.GradeRepository;
import com.trilogyed.gradebookservice.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GradeRepositoryTest {

    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    StudentRepository studentRepository;


    @Before
    public void setUp() throws Exception{
        List<Grade> gradeList = gradeRepository.findAll();
        gradeList.forEach(grade -> {
            gradeRepository.deleteById(grade.getId());
        });

        List<Student> studentList = studentRepository.findAll();

        studentList.forEach(student -> {
            studentRepository.deleteById(student.getStudentId());
        });

        List<Assignment> assignmentList = assignmentRepository.findAll();
        assignmentList.forEach(assignment -> {
            assignmentRepository.deleteById(assignment.getAssignment_id());
        });






    }


    @Test
    public void addGetDeleteGrade(){

        Student testStudent1 = new Student();
        testStudent1.setFirstName("John");
        testStudent1.setLastName("Doe");
        studentRepository.save(testStudent1);


        Assignment testAssignment1 = new Assignment();
        testAssignment1.setName("Test Assignment 1");
        testAssignment1.setDescription("The first assignment I'm testing.");
        assignmentRepository.save(testAssignment1);

        Grade grade = new Grade();
        grade.setStudentId(testStudent1.getStudentId());
        grade.setAssignmentId(testAssignment1.getAssignment_id());
        grade.setPercentGrade(90);
        gradeRepository.save(grade);

        Grade gradeRetrieved = gradeRepository.findById(grade.getId());

        assertEquals(grade, gradeRetrieved);

        gradeRepository.deleteById(grade.getId());

        gradeRetrieved = gradeRepository.findById(grade.getId());
        assertNull(gradeRetrieved);
  }


  @Test
    public void findAllGrades(){
      Student testStudent1 = new Student();
      testStudent1.setFirstName("John");
      testStudent1.setLastName("Doe");
      studentRepository.save(testStudent1);


      Assignment testAssignment1 = new Assignment();
      testAssignment1.setName("Test Assignment 1");
      testAssignment1.setDescription("The first assignment I'm testing.");
      assignmentRepository.save(testAssignment1);

      Assignment testAssignment2 = new Assignment();
      testAssignment2.setName("Test Assignment 2");
      testAssignment2.setDescription("The second assignment I'm testing.");
      assignmentRepository.save(testAssignment2);

      Grade grade = new Grade();
      grade.setStudentId(testStudent1.getStudentId());
      grade.setAssignmentId(testAssignment1.getAssignment_id());
      grade.setPercentGrade(90);
      gradeRepository.save(grade);

      Grade grade1 = new Grade();
      grade1.setStudentId(testStudent1.getStudentId());
      grade1.setAssignmentId(testAssignment2.getAssignment_id());
      grade1.setPercentGrade(92);
      gradeRepository.save(grade1);


      List<Grade> gradeList = gradeRepository.findAll();

      assertEquals(2, gradeList.size());

  }
}
