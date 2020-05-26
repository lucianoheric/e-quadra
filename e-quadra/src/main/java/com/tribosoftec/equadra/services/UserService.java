package com.tribosoftec.equadra.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tribosoftec.equadra.domains.User;
import com.tribosoftec.equadra.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	
	public List<User> listar(){
		return repo.findAll();
	}
	
	public void add(User user) {
		repo.save(user);
	}
	
	public void del(User user) {
		repo.delete(user);
	}
	
	public User edit(User user) {
		return repo.save(user);
	}
	
	public Optional<User> getUser(Long id) {
		return repo.findById(id);
	}
}
