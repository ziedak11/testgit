package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class UserController {
	
	UserRepository repository;
	
	@Autowired
	private UserRepository userRepository;
/// get all users
	@GetMapping("/users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	//// get user by id
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id){
		
		return userRepository.findById(id).orElse(null);
	}
	
	///delete user
	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable Long id){
		
		userRepository.deleteById(id);
		return true;
	}
	
	///create user
	@PostMapping("/user")
public User createUser(@RequestBody User user){
		
		return userRepository.save(user);
		
	}
	
    ////update user
	@PutMapping("/user")
public User updateUser(@RequestBody User user){
		
		return userRepository.save(user);
		
	}
}
