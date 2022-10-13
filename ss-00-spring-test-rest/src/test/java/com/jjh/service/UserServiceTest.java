package com.jjh.service;

import com.jjh.dao.UserDAO;
import com.jjh.domain.User;
import com.jjh.main.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = Application.class)
class UserServiceTest {

    // Stops the original UserDAO being instantiated
    @MockBean
    UserDAO userDAO;

    @Autowired
    private UserService service;

    @BeforeEach
    public void setup() {
        List<User> users = new ArrayList<>();
        users.add(new User("1", "Bill", 30));
        when(userDAO.getUsers()).thenReturn(users);
        service.setUserDAO(userDAO); // Agh if its not a web app must wire it in
    }

    @Test
    void getUsers() {
        List<User> users = service.getUsers();
        assertThat(users.size()).isEqualTo(1);
    }
}