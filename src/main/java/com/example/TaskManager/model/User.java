package com.example.TaskManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private long id;

    private String firstName;
    private String lastName;
    private String timezone;
    private Boolean isActive;

}
