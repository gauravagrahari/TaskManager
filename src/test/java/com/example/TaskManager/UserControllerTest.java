package com.example.TaskManager;


import com.example.TaskManager.controller.UserController;
import com.example.TaskManager.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.annotation.Annotation;

public class UserControllerTest{


    @Test
    public void createUserTest(){
        User user = new User();
        UserController userController = new UserController();
        try {
            User res = ReflectionTestUtils.invokeMethod(userController, "createUser", user);
            Assertions.assertNotNull(res);

        }catch(Exception e){}
    }

    @Test
    public void getAllUsersTest(){
        UserController userController = new UserController();
        try {
            User res = ReflectionTestUtils.invokeMethod(userController, "getAllUsers");
            Assertions.assertNotNull(res);

        }catch(Exception e){}
    }

    @Test
    public void getUserByIdTest(){
        UserController userController = new UserController();
        try {
            User res = ReflectionTestUtils.invokeMethod(userController, "getUserById",1L);
            Assertions.assertNotNull(res);

        }catch(Exception e){}
    }

    @Test
    public void updateUserTest(){
        User user = new User();
        UserController userController = new UserController();
        try {
            User res = ReflectionTestUtils.invokeMethod(userController, "updateUser",1L,user);
            Assertions.assertNotNull(res);

        }catch(Exception e){}
    }

    @Test
    public void deleteUserTest(){
        UserController userController = new UserController();
        try {
            User res = ReflectionTestUtils.invokeMethod(userController, "deleteUser",1L);
            Assertions.assertNotNull(res);

        }catch(Exception e){}
    }
}