package com.trilogyed.gradingedgeservice.util.feign;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.trilogyed.gradingedgeservice.model.Assignment;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "gradebook-service")
public interface AssignmentFeignClient {

    @RequestMapping(path = "/assignment", method = RequestMethod.POST)
    public Assignment addAssignment(@RequestBody Assignment assignment);


    @RequestMapping(path = "/assignment/{id}", method = RequestMethod.GET)
    public Assignment getAssignment(@PathVariable int id);

    @RequestMapping(path = "/assignment", method = RequestMethod.GET)
    public List<Assignment> getAllAssignments();

    @RequestMapping(path = "/assignment/{id}", method = RequestMethod.DELETE)
    public void deleteAssignment(@PathVariable int id);
}
