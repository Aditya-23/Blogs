package com.aditya.blog.services.implementation;

import java.util.ArrayList;
import java.util.List;

import com.aditya.blog.entities.User;
import com.aditya.blog.exceptions.ResourceNotFoundException;
import com.aditya.blog.payloads.UserDto;
import com.aditya.blog.repositories.UserRepo;
import com.aditya.blog.services.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@NoArgsConstructor
@Service
public class UserServiceImplementation implements UserService {

	public UserServiceImplementation(UserRepo userRepoObj) {
		this.userRepoObj = userRepoObj;
	}

	@Autowired
	private UserRepo userRepoObj;
	
	@Override
	public UserDto createUser(UserDto userDtoObj) {
		
		User userObj = this.dtoToUser(userDtoObj);
		User savedUserObj = this.userRepoObj.save(userObj);
		UserDto newUserDtoObj = this.userToDto(savedUserObj);
		
		return newUserDtoObj;
	}

	//UserDto is the object that you get from the client
	//User entity is towards the server side and UserDto is towards the client side

	@Override
	public UserDto updateUser(UserDto userDtoObj, int id) {
		User userObj = this.userRepoObj.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userObj.setUsername(userDtoObj.getUsername());
		userObj.setEmail(userDtoObj.getEmail());
		userObj.setPassword(userDtoObj.getPassword());
		userObj.setAbout(userDtoObj.getAbout());

		User updatedUserObj = this.userRepoObj.save(userObj);
		UserDto userDtoUpdated = this.userToDto(updatedUserObj);

		return userDtoUpdated;
	}

	// Getting the user by id, converting it to dto object and returning
	@Override
	public UserDto getUserById(int id) {
		User userObj = this.userRepoObj.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		UserDto userDtoObj = this.userToDto(userObj);
		return userDtoObj;
	}

	// Get all users
	@Override
	public List<UserDto> getAllUsers(int id) {
		List<User> listOfUser = this.userRepoObj.findAll();
		List<UserDto> listOfUserDto = new ArrayList<>();
		for (User userObj: listOfUser) {
			listOfUserDto.add(this.userToDto(userObj));
		}
		return listOfUserDto;
	}


	// Delete a user
	@Override
	public void deleteUser(int id) {
		User userObj = this.userRepoObj.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		this.userRepoObj.delete(userObj);
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
