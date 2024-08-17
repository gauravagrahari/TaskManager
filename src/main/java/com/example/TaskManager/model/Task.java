package com.example.TaskManager.model;

import lombok.Data;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tasks")
public class Task {

    @Id
    private long id;
    private String title;
    private String description;
    private String status;
    private Date createdAt;
    private Date updatedAt;
    private long userId;
}
