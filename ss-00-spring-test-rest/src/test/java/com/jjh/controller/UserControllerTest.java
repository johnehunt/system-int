package com.jjh.controller;

import com.jjh.domain.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Basic Spring bean style test of a controller
 */
@SpringBootTest(classes = com.jjh.main.Application.class)
class UserControllerTest {

    @Autowired
    private UserController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void getUserForJohn() {
        String name = "John";
        User user = controller.getUser(name);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getAge()).isEqualTo(54);
    }

    @Test
    void getListOfTwoUsers() {
        List<User> users = controller.getUsers();
        assertThat(users.size()).isEqualTo(2);
    }

    @Test
    public void testAddingNewUser() {
        User user = new User("4", "Denise", 53);
        controller.addUser(user);
        List<User> users = controller.getUsers();
        assertThat(users.size()).isEqualTo(3);
    }
}