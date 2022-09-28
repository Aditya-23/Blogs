package com.aditya.blog.services;

import java.util.List;

import com.aditya.blog.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, int id);
	
	UserDto getUserById(int id);
	
	List<UserDto> getAllUsers(int id);
	
	void deleteUser(int id);
}
