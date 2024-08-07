package com.apoolla.crud.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apoolla.crud.entity.User;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Test
	public void addUser() {
		User user = new User();
		user.setFirstName("Aditya");
		user.setLastName("Poolla");
		user.setEmailId("apoolla19@gmail.com");
		user.setPhoneNumber("9402798029");
		userRepository.save(user);
	}
}
