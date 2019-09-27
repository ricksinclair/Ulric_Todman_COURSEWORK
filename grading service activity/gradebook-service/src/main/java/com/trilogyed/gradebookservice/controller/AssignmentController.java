package com.trilogyed.gradebookservice.controller;


import com.trilogyed.gradebookservice.model.Assignment;
import com.trilogyed.gradebookservice.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AssignmentController {

    @Autowired
    AssignmentRepository assignmentRepository;

@RequestMapping(value = "/assignment", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Assignment addAssignment(@Valid @RequestBody Assignment assignment){
    return assignmentRepository.save(assignment);
}

@RequestMapping(value = "/assignment/{assignmentId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Assignment getAssignment(@PathVariable int assignmentId){
    return assignmentRepository.getOne(assignmentId);
}


@RequestMapping(value = "/assignment", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Assignment> getAllAssignments(){
    return assignmentRepository.findAll();
}

@RequestMapping(value = "/assignment", method = RequestMethod.PUT)
    @ResponseStatus (value = HttpStatus.NO_CONTENT)
    public void updateAssignment (@Valid @RequestBody Assignment assignment){
    Assignment updatedAssignment = assignmentRepository.getOne(assignment.getAssignment_id());
    updatedAssignment.setDescription(assignment.getDescription());
    updatedAssignment.setName(assignment.getName());
    assignmentRepository.save(updatedAssignment);
}


@RequestMapping(value = "/assingment/{assignmentId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAssignment(@PathVariable int assignmentId){
    assignmentRepository.deleteById(assignmentId);
}


}

