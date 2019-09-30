package com.trilogyed.gradingedgeservice.util.feign;


import com.trilogyed.gradingedgeservice.model.Grade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="gradebook-service")
public interface GradeFeignClient {

    @RequestMapping(path = "/grades", method = RequestMethod.POST)
    public Grade addGrade(@RequestBody Grade grade);

    @RequestMapping(path = "/grades/{id}", method = RequestMethod.GET)
    public Grade getGrade(@PathVariable int id);

    @RequestMapping(path = "/grades", method = RequestMethod.GET)
    public List<Grade> getAllGrades();

    @RequestMapping(path="/grades/{id}", method = RequestMethod.DELETE)
    public void deleteGrade(@PathVariable int id);



}
