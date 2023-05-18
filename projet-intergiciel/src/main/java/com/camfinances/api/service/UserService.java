package com.camfinances.api.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.camfinances.api.model.User;
import com.camfinances.api.repository.UserRepository;

import lombok.Data;

@Data
@Service

public class UserService {

    @Autowired
	private UserRepository UserRepository;
	
	public Optional<User> getUser(final Long id) {
		return UserRepository.findById(id);
	}

	public Optional<User> getUser(String email, String mdp) {
		return UserRepository.findByEmailAndMdp(email, mdp);
	}
	
	public Iterable<User> getUsers() {
		return UserRepository.findAll();
	}
	
	public void deleteUser(final Long id) {
		UserRepository.deleteById(id);
	}
	
	public User saveUser(User user) {
		User savedUser = UserRepository.save(user);
		return savedUser;
	}

    
}
