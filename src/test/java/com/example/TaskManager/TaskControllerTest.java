package com.example.TaskManager;

import com.example.TaskManager.controller.TaskController;
import com.example.TaskManager.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

public class TaskControllerTest {

    @InjectMocks
    TaskController taskController;

    @Test
    public void createTaskTest(){
        Task task = new Task();
        Long id = 1L;
        Task result = ReflectionTestUtils.invokeMethod(taskController,"createTask",task,id);
        Assertions.assertNotNull(result);
    }

    @Test
    public void getTaskByIdTest(){
        Long id = 1L;
        ResponseEntity<Task> res  = ReflectionTestUtils.invokeMethod(taskController,"getTaskById",id);
        Assertions.assertNotNull(res);
    }

    @Test
    public void getAllTasksTest(){
        List<Task> res = ReflectionTestUtils.invokeMethod(taskController,"getAllTasks");
        Assertions.assertNotNull(res);
    }
    @Test
    public void updateTaskTest(){
        Task task = new Task();
        Long id = 1L;
        ResponseEntity<Task> res  = ReflectionTestUtils.invokeMethod(taskController,"updateTask",id,task);
        Assertions.assertNotNull(res);
    }
    @Test
    public void deleteTaskTest(){
        Long id = 1L;
        ResponseEntity<Void> res = ReflectionTestUtils.invokeMethod(taskController,"deleteTask",id);
        Assertions.assertNotNull(res);
    }
}