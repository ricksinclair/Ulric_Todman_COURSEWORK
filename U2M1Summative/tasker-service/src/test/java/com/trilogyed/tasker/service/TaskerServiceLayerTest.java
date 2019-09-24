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

import static org.junit.Assert.assertEquals;
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
        public void addGetDeleteTasks(){
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


        private void setUpTaskerDaoMock(){
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


            doReturn(taskProcessed).when(taskerDao).createTask(task);
            doReturn(taskProcessed1).when(taskerDao).createTask(task1);
            doReturn(taskProcessed).when(taskerDao).getTask(taskProcessed.getId());
            doReturn(taskProcessed1).when(taskerDao).getTask(taskProcessed1.getId());
            doReturn(taskUpdated).when(taskerDao).getTask(taskUpdated.getId());
            doNothing().when(taskerDao).updateTask(taskUpdated);




//

//

//
//            TaskViewModel tvm1 = new TaskViewModel();
//            tvm1.setDescription(task1.getDescription());
//            tvm1.setCategory(task1.getCategory());
//            tvm1.setCreateDate(task1.getCreateDate());
//            tvm1.setDueDate(task1.getDueDate());
//
//            TaskViewModel tvmProcessed1 = new TaskViewModel();
//            tvmProcessed1.setId(taskProcessed1.getId());
//            tvmProcessed1.setDescription(taskProcessed1.getDescription());
//            tvmProcessed1.setDueDate(taskProcessed1.getDueDate());
//            tvmProcessed1.setCreateDate(taskProcessed1.getCreateDate());
//            tvmProcessed1.setCategory(taskProcessed1.getCategory());
//            tvmProcessed1.setAdvertisement(adServerFeignClient.getRandomAd());


        }

        private void setUpAdServerFeignClient(){
            adServerFeignClient = mock(AdServerFeignClient.class);
            String ad = "This is a test ad";
            doReturn(ad).when(adServerFeignClient).getRandomAd();
        }
}
