package com.trilogyed.gradebookservice.respository;


import com.trilogyed.gradebookservice.model.Assignment;
import com.trilogyed.gradebookservice.repository.AssignmentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AssignmentRepositoryTest {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Before
    public void setUp() throws Exception{
        List<Assignment> assignmentList = assignmentRepository.findAll();
        assignmentList.forEach(assignment -> {
           assignmentRepository.deleteById(assignment.getAssignment_id());
        });
    }



    @Test
    public void addGetDeleteAssignment(){
        Assignment testAssignment1 = new Assignment();
        testAssignment1.setName("Test Assignment 1");
        testAssignment1.setDescription("The first assignment I'm testing.");
        assignmentRepository.save(testAssignment1);
        Assignment testAssignment1Retrieved;
        testAssignment1Retrieved = assignmentRepository.findById(testAssignment1.getAssignment_id());
        assertEquals(testAssignment1, testAssignment1Retrieved);


    }

    @Test
    public void getAllAssignments(){
        Assignment testAssignment1 = new Assignment();
        testAssignment1.setName("Test Assignment 1");
        testAssignment1.setDescription("The first assignment I'm testing.");
        assignmentRepository.save(testAssignment1);

        Assignment testAssignment2 = new Assignment();
        testAssignment2.setName("Test Assignment 2");
        testAssignment2.setDescription("The second assignment I'm testing.");
        assignmentRepository.save(testAssignment2);

        List<Assignment> assignmentList = assignmentRepository.findAll();
        assertEquals(2, assignmentList.size());


    }
}
