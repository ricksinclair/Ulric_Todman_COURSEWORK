package com.trilogyed.gradebookservice.controller;


import com.netflix.discovery.converters.Auto;
import com.trilogyed.gradebookservice.model.Grade;
import com.trilogyed.gradebookservice.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GradeController {

    @Autowired
    GradeRepository gradeRepository;

    @RequestMapping(value = "/grades", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Grade addGrade(@Valid @RequestBody Grade grade){
        return gradeRepository.save(grade);
    }

    @RequestMapping(value = "/grades/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Grade getGrade(@PathVariable int id){
        return gradeRepository.getOne(id);
    }

    @RequestMapping(value = "/grades", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Grade> getallGrades(){
        return gradeRepository.findAll();
    }

    @RequestMapping(value = "/grades", method = RequestMethod.PUT)
    @ResponseStatus (value = HttpStatus.NO_CONTENT)
    public void updateGrade(@Valid @RequestBody Grade grade){
        Grade updatedGrade = gradeRepository.getOne(grade.getId());
        updatedGrade.setAssignmentId(grade.getAssignmentId());
        updatedGrade.setPercentGrade(grade.getPercentGrade());
        updatedGrade.setStudentId(grade.getStudentId());
        gradeRepository.save(updatedGrade);

    }

    @RequestMapping(value = "/grades/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGrade(@PathVariable int id){
        gradeRepository.deleteById(id);
    }

}
