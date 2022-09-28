package com.aditya.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



// Can be exposed. Used for data transfer throughout the application. User entity cannot be exposed to the user.
@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	
	private int id;
	private String username;
	private String email;
	private String password;
	private String about;
}
