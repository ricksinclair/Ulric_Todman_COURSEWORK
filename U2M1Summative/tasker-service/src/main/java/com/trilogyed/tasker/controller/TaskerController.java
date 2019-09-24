package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RefreshScope
@RestController
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    public TaskViewModel getTasksById(@PathVariable int id) throws Exception{
        return service.fetchTask(id);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public TaskViewModel addTask(@Valid @RequestBody TaskViewModel tvm){
        return service.newTask(tvm);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<TaskViewModel> getAllTasks(){
        return service.fetchAllTasks();
    }

    @RequestMapping(value="/tasks/category/{category}", method = RequestMethod.GET)
    public List<TaskViewModel> getTasksByCategory(@PathVariable String category){
        return service.fetchTasksByCategory(category);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    public void updateTask(@RequestBody TaskViewModel tvm){
        service.updateTask(tvm);
    }

}
