package com.example.TaskManager.service;

import com.example.TaskManager.model.Task;
import com.example.TaskManager.model.User;
import com.example.TaskManager.repository.TaskRepository;
import com.example.TaskManager.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTask_shouldSaveTask() {
        Task task = new Task();
        task.setTitle("Test Task");

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task createdTask = taskService.createTask(task);

        assertEquals(task.getTitle(), createdTask.getTitle());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void getAllTasks_shouldReturnAllTasks() {
        Task task1 = new Task();
        Task task2 = new Task();

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        assertEquals(2, taskService.getAllTasks().size());
    }

    @Test
    void getTaskById_shouldReturnTask() {
        Task task = new Task();
        task.setId(1L);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Optional<Task> foundTask = taskService.getTaskById(1L);

        assertEquals(task.getId(), foundTask.get().getId());
    }

    @Test
    void updateTask_shouldUpdateTask() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Old Title");

        Task updatedTask = new Task();
        updatedTask.setTitle("New Title");

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        when(taskRepository.save(any(Task.class))).thenReturn(updatedTask);

        Task result = taskService.updateTask(1L, updatedTask);

        assertEquals("New Title", result.getTitle());
    }

    @Test
    void updateTask_shouldThrowExceptionWhenTaskNotFound() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            taskService.updateTask(1L, new Task());
        });
    }

    @Test
    void deleteTask_shouldDeleteTask() {
        Task task = new Task();
        task.setId(1L);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        taskService.deleteTask(1L);

        verify(taskRepository, times(1)).deleteById(1L);
    }
}
