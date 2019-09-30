package com.trilogyed.gradingedgeservice.util.feign;


import com.trilogyed.gradingedgeservice.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("gradebook-service")
public interface StudentFeignClient {

@RequestMapping(value = "/student", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student );


@RequestMapping(value ="/student", method = RequestMethod.GET)
    public List<Student> getAllStudents();


@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable int id);

@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public Student deleteStudentById(@PathVariable int id);

}
