package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerFeignClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerServiceLayerTest {

        TaskerDao taskerDao;

        AdServerFeignClient adServerFeignClient;

        TaskerServiceLayer service;

        @Before
        public void setUp() throws Exception{
            setUpTaskerDaoMock();
            setUpAdServerFeignClient();

            service = new TaskerServiceLayer( adServerFeignClient,taskerDao);
        }


        @Test
        public void addGetTasks() throws Exception {
            Task task = new Task();
            task.setDescription("This is a test task");
            task.setCategory("test");
            task.setCreateDate(LocalDate.of(2019, 9, 23));
            task.setDueDate(LocalDate.of(2019, 9, 24));

            TaskViewModel tvm = new TaskViewModel();
            tvm.setDescription(task.getDescription());
            tvm.setCategory(task.getCategory());
            tvm.setCreateDate(task.getCreateDate());
            tvm.setDueDate(task.getDueDate());

            tvm = service.newTask(tvm);
            TaskViewModel tvmProcessed = new TaskViewModel();
            tvmProcessed.setId(1);
            tvmProcessed.setDescription(task.getDescription());
            tvmProcessed.setDueDate(task.getDueDate());
            tvmProcessed.setCreateDate(task.getCreateDate());
            tvmProcessed.setCategory(task.getCategory());
            tvmProcessed.setAdvertisement(adServerFeignClient.getRandomAd());

            assertEquals(tvm, tvmProcessed);



        }


        @Test
        public void deleteTasks(){
            service.deleteTask(4);

            assertNull(service.fetchTask(4));
        }

        @Test
        public void updateTasks(){
            TaskViewModel taskUpdated = new TaskViewModel();
            taskUpdated.setId(3);
            taskUpdated.setDescription("This is task that hasn't been updated");
            taskUpdated.setCategory("test");
            taskUpdated.setCreateDate(LocalDate.of(2019, 9, 23));
            taskUpdated.setDueDate(LocalDate.of(2019, 9, 24));
            taskUpdated.setAdvertisement(adServerFeignClient.getRandomAd());
            service.updateTask(taskUpdated);
            TaskViewModel fromService = service.fetchTask(taskUpdated.getId());
            assertEquals(taskUpdated, fromService);

        }



        @Test
        public void listTests(){
            Task task = new Task();
            task.setDescription("This is a test task");
            task.setCategory("test");
            task.setCreateDate(LocalDate.of(2019, 9, 23));
            task.setDueDate(LocalDate.of(2019, 9, 24));
            TaskViewModel taskViewModel = new TaskViewModel();
            taskViewModel.setDescription(task.getDescription());
            taskViewModel.setCategory(task.getCategory());
            taskViewModel.setCreateDate(task.getCreateDate());
            taskViewModel.setDueDate(task.getDueDate());
            taskViewModel = service.newTask(taskViewModel);


            Task task1 = new Task();
            task1.setDescription("This is a test task");
            task1.setCategory("test");
            task1.setCreateDate(LocalDate.of(2019, 9, 23));
            task1.setDueDate(LocalDate.of(2019, 9, 25));
            TaskViewModel taskViewModel1 = new TaskViewModel();
            taskViewModel1.setDescription(task1.getDescription());
            taskViewModel1.setCreateDate(task1.getCreateDate());
            taskViewModel1.setCategory(task1.getCategory());
            taskViewModel1.setDueDate(task1.getDueDate());
            taskViewModel1 = service.newTask(taskViewModel1);





            Task randomTaskNotAdded = new Task();
            randomTaskNotAdded.setDescription("This is task that hasn't been updated");
            randomTaskNotAdded.setCategory("random");
            randomTaskNotAdded.setCreateDate(LocalDate.of(2019, 9, 23));
            randomTaskNotAdded.setDueDate(LocalDate.of(2019, 9, 24));
            TaskViewModel randomTaskViewModel = new TaskViewModel();
            randomTaskViewModel.setDescription(randomTaskNotAdded.getDescription());
            randomTaskViewModel.setCategory(randomTaskNotAdded.getCategory());
            randomTaskViewModel.setCreateDate(randomTaskNotAdded.getCreateDate());
            randomTaskViewModel.setDueDate(randomTaskNotAdded.getDueDate());
            randomTaskViewModel = service.newTask(randomTaskViewModel);

            List<TaskViewModel> taskViewModels = service.fetchAllTasks();

            assertEquals(3, taskViewModels.size());

            List<TaskViewModel> testTasks = service.fetchTasksByCategory("test");
            assertEquals(2, testTasks.size());

            List<TaskViewModel> randomTasks = service.fetchTasksByCategory("random");
            assertEquals(1, randomTasks.size());



        }


        public void setUpTaskerDaoMock(){
            taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);
            Task task = new Task();
            task.setDescription("This is a test task");
            task.setCategory("test");
            task.setCreateDate(LocalDate.of(2019, 9, 23));
            task.setDueDate(LocalDate.of(2019, 9, 24));

            Task taskProcessed = new Task();
            taskProcessed.setId(1);
            taskProcessed.setDescription("This is a test task");
            taskProcessed.setCategory("test");
            taskProcessed.setCreateDate(LocalDate.of(2019, 9, 23));
            taskProcessed.setDueDate(LocalDate.of(2019, 9, 24));

                 Task task1 = new Task();
            task1.setDescription("This is a test task");
            task1.setCategory("test");
            task1.setCreateDate(LocalDate.of(2019, 9, 23));
            task1.setDueDate(LocalDate.of(2019, 9, 25));

            Task taskProcessed1 = new Task();
            taskProcessed1.setId(2);
            taskProcessed1.setDescription("This is a test task");
            taskProcessed1.setCategory("test");
            taskProcessed1.setCreateDate(LocalDate.of(2019, 9, 23));
            taskProcessed1.setDueDate(LocalDate.of(2019, 9, 25));


            Task taskUpdated = new Task();
            taskUpdated.setId(3);
            taskUpdated.setDescription("This is task that hasn't been updated");
            taskUpdated.setCategory("test");
            taskUpdated.setCreateDate(LocalDate.of(2019, 9, 23));
            taskUpdated.setDueDate(LocalDate.of(2019, 9, 24));

             Task taskDeleted = new Task();
            taskDeleted.setId(4);
            taskDeleted.setDescription("This will be deleted");
            taskDeleted.setCategory("test");
            taskDeleted.setCreateDate(LocalDate.of(2019, 9, 23));
            taskDeleted.setDueDate(LocalDate.of(2019, 9, 24));

            Task randomTaskNotAdded = new Task();
            randomTaskNotAdded.setDescription("This is task that hasn't been updated");
            randomTaskNotAdded.setCategory("random");
            randomTaskNotAdded.setCreateDate(LocalDate.of(2019, 9, 23));
            randomTaskNotAdded.setDueDate(LocalDate.of(2019, 9, 24));

            Task randomTaskAdded = new Task();
            randomTaskAdded.setId(5);
            randomTaskNotAdded.setDescription("This is task that hasn't been updated");
            randomTaskNotAdded.setCategory("random");
            randomTaskNotAdded.setCreateDate(LocalDate.of(2019, 9, 23));
            randomTaskNotAdded.setDueDate(LocalDate.of(2019, 9, 24));

            List<Task> taskList = new ArrayList<Task>();
            taskList.add(taskProcessed);
            taskList.add(taskProcessed1);
            taskList.add(randomTaskAdded);

            List<Task> taskListsTest = new ArrayList<Task>();
            taskListsTest.add(taskProcessed);
            taskListsTest.add(taskProcessed1);

            List<Task> taskList1 = new ArrayList<Task>();
            taskList1.add(randomTaskAdded);


            doReturn(taskProcessed).when(taskerDao).createTask(task);
            doReturn(taskProcessed1).when(taskerDao).createTask(task1);
            doReturn(taskProcessed).when(taskerDao).getTask(taskProcessed.getId());
            doReturn(taskProcessed1).when(taskerDao).getTask(taskProcessed1.getId());
            doReturn(taskUpdated).when(taskerDao).getTask(taskUpdated.getId());
            doNothing().when(taskerDao).updateTask(taskUpdated);
            doNothing().when(taskerDao).deleteTask(4);
            doReturn(null).when(taskerDao).getTask(4);
            doReturn(taskList).when(taskerDao).getAllTasks();
            doReturn(taskListsTest).when(taskerDao).getTasksByCategory("test");
            doReturn(randomTaskAdded).when(taskerDao).createTask(randomTaskNotAdded);
            doReturn(taskList1).when(taskerDao).getTasksByCategory("random");


        }

        private void setUpAdServerFeignClient(){
            adServerFeignClient = mock(AdServerFeignClient.class);
            String ad = "This is a test ad";
            doReturn(ad).when(adServerFeignClient).getRandomAd();
        }
}
