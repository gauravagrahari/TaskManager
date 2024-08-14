package com.example.TaskManager;

import com.example.TaskManager.controller.UserController;
import com.example.TaskManager.model.Task;
import com.example.TaskManager.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.util.ReflectionTestUtils;

public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Test
    public void createUserTest(){
        User user = new User();
        ReflectionTestUtils.invokeMethod(userController,"createUser",user);
    }

    @Test
    public void getAllUsersTest(){
        ReflectionTestUtils.invokeMethod(userController,"getAllUsers");
    }
    @Test
    public void getUserByIdTest(){
        Long id = 1L;
        ReflectionTestUtils.invokeMethod(userController,"getUserById",id);
    }
}