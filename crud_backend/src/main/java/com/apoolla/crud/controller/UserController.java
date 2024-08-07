package com.apoolla.crud.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.apoolla.crud.dto.UserDto;
import com.apoolla.crud.entity.User;
import com.apoolla.crud.mapper.UserMapper;
import com.apoolla.crud.repository.UserRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@GetMapping(path = "/{userId}")
	public UserDto getUser(@PathVariable("userId") Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isEmpty()) {
			String errorMessage = String.format("User with user id %i not found", userId);
			;
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
		}
		return userMapper.mapToDTO(user.get());
	}

	@GetMapping	
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map(userMapper::mapToDTO).collect(Collectors.toList());
	}

	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
		User userEntity = userRepository.save(userMapper.mapToEntity(user));
		return new ResponseEntity<UserDto>(userMapper.mapToDTO(userEntity), HttpStatus.CREATED);
	}
}
