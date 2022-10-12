package com.jjh.dao;

import com.jjh.domain.User;
import com.jjh.domain.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {

    private List<User> users = new ArrayList<>();

    public UserDAO() {
        System.out.println("UserDAO.<init>()");
        User user = new User("1", "Bill", 30);
        users.add(user);
        user = new User("2", "Ben", 28);
        users.add(user);
    }

    public List<User> getUsers() {
        System.out.println("UserDAO.getUsers()");
        return users;
    }

    public User getUser(String name) {
        System.out.println("UserDAO.getUser(" + name + ")");
        return new User("x", name, 54);
    }

    public void addUser(User user) {
        System.out.println("UserDAO.addUser(" + user + ")");
        if (!this.users.contains(user)) {
            this.users.add(user);
        }
    }

    public void updateUser(User newVersionOfUser) {
        System.out.println("UserDAO.updateUser(" + newVersionOfUser + ")");
        User originalUser = this.getUser(newVersionOfUser.getId());
        if (originalUser == null)
            throw new UserNotFoundException("User with isbn: " + newVersionOfUser.getId() + " not found");
        originalUser.setName(newVersionOfUser.getName());
        originalUser.setTitle(newVersionOfUser.getTitle());
        originalUser.setAge(newVersionOfUser.getAge());
    }

    public void deleteUser(String isbn) {
        System.out.println("UserDAO.deleteUser(" + isbn + ")");
        User user = this.getUser(isbn);
        if (user != null)
            this.users.remove(user);
        else
            throw new UserNotFoundException("User with isbn: " + isbn + " not found");
    }

}
