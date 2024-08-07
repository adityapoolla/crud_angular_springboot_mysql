package com.apoolla.crud.mapper;

import org.springframework.stereotype.Service;

import com.apoolla.crud.dto.UserDto;
import com.apoolla.crud.entity.User;

@Service
public class UserMapper implements Mapper<User, UserDto> {

	@Override
	public UserDto mapToDTO(User user) {
		return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmailId());
	}

	@Override
	public User mapToEntity(UserDto userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmailId(userDto.getEmailId());
		return user;
	}

}
