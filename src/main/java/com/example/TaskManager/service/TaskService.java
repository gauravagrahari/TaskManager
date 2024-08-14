package com.example.TaskManager.service;

import com.example.TaskManager.model.Task;
import com.example.TaskManager.model.TaskValidator;
import com.example.TaskManager.model.User;
import com.example.TaskManager.repository.TaskRepository;
import com.example.TaskManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

@Service
public class TaskService {

    UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found"));
        task.setAssignedTo(user);

        // Set time in UTC based on the user's timezone or provided timezone
        LocalDateTime utcTime = LocalDateTime.now(ZoneId.of("UTC"));
        task.setCreatedAt(utcTime);
        task.setUpdatedAt(utcTime);

        return taskRepository.save(task);
    }

// Similar adjustments in updateTask method

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return Optional.ofNullable(taskRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Task not found")));
    }

    public Task updateTask(Long id, Task updatedTask) {
        TaskValidator.validateTask(updatedTask); // Validate before updating
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            return taskRepository.save(task);
        }).orElseThrow(() -> new NoSuchElementException("Task not found"));
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new NoSuchElementException("Task not found");
        }
        taskRepository.deleteById(id);
    }
}
