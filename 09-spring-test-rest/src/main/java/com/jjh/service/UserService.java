package com.jjh.service;

import com.jjh.dao.UserDAO;
import com.jjh.domain.User;
import com.jjh.domain.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        System.out.println("UserService.<cons>()");
        this.userDAO = userDAO;
    }

    void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getUsers() {
        System.out.println("UserService.getUsers()");
        return userDAO.getUsers();
    }

    public User getUser(String name) {
        System.out.println("UserService.getUser(" + name + ")");
        return new User("x", name, 54);
    }

    public void addUser(User user) {
        System.out.println("UserService.addUser(" + user + ")");
        userDAO.addUser(user);
    }

    public void updateUser(User newVersionOfUser) {
        System.out.println("UserService.updateUser(" + newVersionOfUser + ")");
        userDAO.updateUser(newVersionOfUser);
    }

    public void deleteUser(String isbn) {
        System.out.println("UserService.deleteUser(" + isbn + ")");
        userDAO.deleteUser(isbn);
    }


}
