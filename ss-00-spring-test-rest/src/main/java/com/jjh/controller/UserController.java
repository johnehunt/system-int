package com.jjh.controller;

import com.jjh.domain.User;
import com.jjh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
    	this.userService = userService;
	}

	// http://localhost:8080/users/user/john

	//@RequestMapping("user/{name}", method = RequestMethod.GET) // default request method
	@GetMapping("user/{name}")
	public User getUser(@PathVariable String name) {
		System.out.println("UserController.getUser(" + name + ")");
		return userService.getUser(name);
	}

	// http://localhost:8080/users/list

	@GetMapping("list")
	public List<User> getUsers() {
		System.out.println("UserController.getUsers()");
		return userService.getUsers();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addUser(@RequestBody User user) {
		System.out.println("UserController.addUser(" + user + ")");
		this.userService.addUser(user);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void updateUser(@RequestBody User user) {
		System.out.println("UserController.updateUser(" + user + ")");
		this.userService.updateUser(user);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable String id) {
		System.out.println("UserController.deleteUser(" + id + ")");
		userService.deleteUser(id);
	}
}