package com.trilogyed.tasker.dao;


import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTest {

    @Autowired
    protected TaskerDao dao;


    @Before
    public void setUp() throws Exception {

        List<Task> taskList = dao.getAllTasks();
        taskList.forEach(task -> {
            dao.deleteTask(task.getId());
        });
    }


    @Test
    public void addGetDeleteTask() {
        Task task = new Task();
        task.setDescription("This is a test task");
        task.setCategory("test");
        task.setCreateDate(LocalDate.of(2019, 9, 23));
        task.setDueDate(LocalDate.of(2019, 9, 24));
        task = dao.createTask(task);
        Task task1 = dao.getTask(task.getId());
        assertEquals(task, task1);
        dao.deleteTask(task.getId());
        task1 = dao.getTask(task.getId());
        assertNull(task1);
    }

    @Test
    public void getAllTasksAndByCategory() {
        Task task = new Task();
        task.setDescription("This is a test task");
        task.setCategory("test");
        task.setCreateDate(LocalDate.of(2019, 9, 23));
        task.setDueDate(LocalDate.of(2019, 9, 24));
        task = dao.createTask(task);

        Task task1 = new Task();
        task1.setDescription("This is the second task1 in the list");
        task1.setCategory("test");
        task1.setCreateDate(LocalDate.of(2019, 9, 23));
        task1.setDueDate(LocalDate.of(2019, 9, 25));
        task1 = dao.createTask(task1);

        List<Task> taskList = dao.getAllTasks();
        List<Task> testTasks = dao.getTasksByCategory("test");
        assertEquals(taskList, testTasks);
        Task task2 = new Task();
        task2.setDescription("This is a test task2");
        task2.setCategory("test cat2");
        task2.setCreateDate(LocalDate.of(2019, 9, 23));
        task2.setDueDate(LocalDate.of(2019, 9, 24));
        task2 = dao.createTask(task2);
        taskList = dao.getAllTasks();
        assertEquals(3, taskList.size());
        testTasks = dao.getTasksByCategory("test");
        assertEquals(2, testTasks.size());
    }

    @Test
    public void updateTaskTest() {
        Task task = new Task();
        task.setDescription("This is a test task");
        task.setCategory("test");
        task.setCreateDate(LocalDate.of(2019, 9, 23));
        task.setDueDate(LocalDate.of(2019, 9, 24));
        task = dao.createTask(task);

        task.setDescription("Updated Task");
        dao.updateTask(task);

        Task task1 = dao.getTask(task.getId());

        assertEquals(task, task1);
    }

}
