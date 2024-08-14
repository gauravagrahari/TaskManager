package com.example.TaskManager;


import com.example.TaskManager.controller.TaskController;
import com.example.TaskManager.model.Task;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

public class TaskControllerTest {

    @InjectMocks
    TaskController taskController;

    @Test
    public void createTaskTest(){
        Task task = new Task();
        Long id = 1L;
        ReflectionTestUtils.invokeMethod(taskController,"createTask",task,id);
    }

    @Test
    public void getTaskByIdTest(){
        Long id = 1L;
        ReflectionTestUtils.invokeMethod(taskController,"getTaskById",id);
    }

    @Test
    public void getAllTasksTest(){
        Task task = new Task();
        Long id = 1L;
        ReflectionTestUtils.invokeMethod(taskController,"getAllTasks");
    }
    @Test
    public void updateTaskTest(){
        Task task = new Task();
        Long id = 1L;
        ReflectionTestUtils.invokeMethod(taskController,"updateTask",id,task);
    }
    @Test
    public void deleteTaskTest(){
        Task task = new Task();
        Long id = 1L;
        ReflectionTestUtils.invokeMethod(taskController,"deleteTask",id);
    }
}