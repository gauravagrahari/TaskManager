package com.example.TaskManager.model;


import java.util.Arrays;
import java.util.List;

public class TaskValidator {

    private static final List<String> VALID_STATUSES = Arrays.asList("Pending", "In Progress", "Completed");

    public static void validateTask(Task task) {
        validateTitle(task.getTitle());
        validateStatus(task.getStatus());
    }

    public static void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title is mandatory and cannot be null or empty.");
        }
    }

    public static void validateStatus(String status) {
        if (!VALID_STATUSES.contains(status)) {
            throw new IllegalArgumentException("Status must be one of the following: " + VALID_STATUSES);
        }
    }
}
