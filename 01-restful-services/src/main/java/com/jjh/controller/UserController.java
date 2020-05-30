package com.jjh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjh.domain.User;

@RestController
@RequestMapping("users")
public class UserController {
	private List<User> users = new ArrayList<User>();

	public UserController() {
		System.out.println("UserController.<cons>()");
		User user = new User("Bill", 30);
		users.add(user);
		user = new User("Ben", 28);
		users.add(user);
	}

	//@RequestMapping("user/{name}", method = RequestMethod.GET) // default request method
	@GetMapping("user/{name}")
	public User getUser(@PathVariable String name) {
		System.out.println("UserController.getUser(" + name + ")");
		User user = new User(name, 54);
		return user;
	}

	@GetMapping("list")
	public List<User> getUsers() {
		System.out.println("UserController.getUsers()");
		return users;
	}
}