package com.aditya.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.blog.entities.User;


//Repositories use User not UserDto.
public interface UserRepo extends JpaRepository<User, Integer> {
	
}
