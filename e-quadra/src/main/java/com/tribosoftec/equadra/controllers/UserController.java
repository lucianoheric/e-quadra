package com.tribosoftec.equadra.controllers;

import java.util.List;
import java.util.Optional;

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

import com.tribosoftec.equadra.domains.User;
import com.tribosoftec.equadra.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	private UserService service;
	@CrossOrigin
	@GetMapping
	public List<User> listar() {
		return service.listar();
	}
	
	@CrossOrigin
	@PostMapping
	public void add(@RequestBody User user) {
		service.add(user);
	}	
	
	@CrossOrigin
	@DeleteMapping
	public void del(@RequestBody User user) {
		service.del(user);
	}	
	
	@CrossOrigin
	@PutMapping
	public void edit(@RequestBody User user) {
		service.edit(user);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		return service.getUser(id);
	}

}
