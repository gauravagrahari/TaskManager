package com.example.TaskManager.service;

import com.example.TaskManager.model.Task;
import com.example.TaskManager.repository.TaskRepository;
import com.example.TaskManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService {

    UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    public Task updateTask(long id,Task task){
        Task retrievedTask = taskRepository.findById(id).get();
        retrievedTask.setDescription(task.getDescription());
        retrievedTask.setTitle(task.getTitle());
        retrievedTask.setCreatedAt(task.getCreatedAt());
        retrievedTask.setUpdatedAt(task.getUpdatedAt());
        retrievedTask.setStatus(task.getStatus());
        return taskRepository.save(retrievedTask);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new NoSuchElementException("Task not found");
        }
        taskRepository.deleteById(id);
    }
}
