package com.example.TaskManager;

import com.example.TaskManager.controller.TaskController;
import com.example.TaskManager.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

public class TaskControllerTest {


    @Test
    public void createTaskTest(){
        Task task = new Task();
        Long id = 1L;
        TaskController taskController = new TaskController();
        try {
            Task result = ReflectionTestUtils.invokeMethod(taskController, "createTask", task);
            Assertions.assertNotNull(result);
        }catch(Exception e){}
    }

    @Test
    public void getTaskByIdTest(){
        Long id = 1L;
        TaskController taskController = new TaskController();
        try {
            ResponseEntity<Task> res = ReflectionTestUtils.invokeMethod(taskController, "getTaskById", id);
            Assertions.assertNotNull(res);
        }catch(Exception e){}
    }

    @Test
    public void getAllTasksTest(){
        TaskController taskController = new TaskController();
        try {
            List<Task> res = ReflectionTestUtils.invokeMethod(taskController, "getAllTasks");
            Assertions.assertNotNull(res);
        }catch(Exception e){}
    }
    @Test
    public void updateTaskTest(){
        Task task = new Task();
        Long id = 1L;
        TaskController taskController = new TaskController();
        try {
            ResponseEntity<Task> res = ReflectionTestUtils.invokeMethod(taskController, "updateTask", id, task);
            Assertions.assertNotNull(res);
        }catch(Exception e){}
    }
    @Test
    public void deleteTaskTest(){
        Long id = 1L;
        TaskController taskController = new TaskController();
        try {
            ResponseEntity<Void> res = ReflectionTestUtils.invokeMethod(taskController, "deleteTask", id);
            Assertions.assertNotNull(res);
        }catch(Exception e){}
    }
}