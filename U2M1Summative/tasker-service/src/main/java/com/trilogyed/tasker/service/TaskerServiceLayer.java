package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    TaskerDao dao;

    @Autowired
    private final AdServerFeignClient client;


    TaskerServiceLayer(AdServerFeignClient client){
        this.client= client;
    }

    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        tvm.setAdvertisement(client.getRandomAd());
        // TODO - get ad from Adserver and put in tvm

        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task> taskList = dao.getAllTasks();
        List<TaskViewModel> taskViewModels = new ArrayList<TaskViewModel>();
        taskList.forEach(task->{
            TaskViewModel tvm = new TaskViewModel();
            tvm.setAdvertisement(client.getRandomAd());
            tvm.setId(task.getId());
            tvm.setCategory(task.getCategory());
            tvm.setCreateDate(task.getCreateDate());
            tvm.setDueDate(task.getDueDate());
            tvm.setDescription(task.getDescription());
            taskViewModels.add(tvm);
        });


        return taskViewModels;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> taskList = dao.getTasksByCategory(category);
        List<TaskViewModel> taskViewModels = new ArrayList<TaskViewModel>();
        taskList.forEach(task->{
            TaskViewModel tvm = new TaskViewModel();
            tvm.setAdvertisement(client.getRandomAd());
            tvm.setId(task.getId());
            tvm.setCategory(task.getCategory());
            tvm.setCreateDate(task.getCreateDate());
            tvm.setDueDate(task.getDueDate());
            tvm.setDescription(task.getDescription());
            taskViewModels.add(tvm);
        });

        return taskViewModels;
    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(task.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getId());
        taskViewModel.setAdvertisement(client.getRandomAd());
        // TODO - get ad from Adserver and put in taskViewModel
        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setId(taskViewModel.getId());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setCategory(taskViewModel.getCategory());
        task.setDescription(taskViewModel.getDescription());
        dao.updateTask(task);
    }
}
