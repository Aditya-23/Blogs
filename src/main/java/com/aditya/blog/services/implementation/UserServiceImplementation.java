package com.aditya.blog.services.implementation;

import java.util.List;

import com.aditya.blog.entities.User;
import com.aditya.blog.payloads.UserDto;
import com.aditya.blog.repositories.UserRepo;
import com.aditya.blog.services.UserService;

public class UserServiceImplementation implements UserService {

	private UserRepo userRepoObj;
	
	@Override
	public UserDto createUser(UserDto userDtoObj) {
		
		User userObj = this.dtoToUser(userDtoObj);
		User savedUserObj = this.userRepoObj.save(userObj);
		UserDto newUserDtoObj = this.userToDto(savedUserObj);
		
		return newUserDtoObj;
	}

	@Override
	public UserDto updateUser(UserDto user, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
	}
	
	public User dtoToUser(UserDto userDtoObj) {
		// populating user object with the corresponding fields of userDto object.
		User userObj = new User();
		userObj.setId(userDtoObj.getId());
		userObj.setUsername(userDtoObj.getUsername());
		userObj.setEmail(userDtoObj.getEmail());
		userObj.setPassword(userDtoObj.getPassword());
		userObj.setAbout(userDtoObj.getAbout());
		
		return userObj;
	}
	
	public UserDto userToDto(User userObj) {
		// populating userDto object with the corresponding fields of user object.
		UserDto userDtoObj = new UserDto();
		userDtoObj.setId(userObj.getId());
		userDtoObj.setUsername(userObj.getUsername());
		userDtoObj.setEmail(userObj.getEmail());
		userDtoObj.setPassword(userObj.getPassword());
		userDtoObj.setAbout(userObj.getAbout());
		
		return userDtoObj;
	}

}
