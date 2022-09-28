package com.aditya.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



//Used to deal with the database, It is corresponding to a database.

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	@Column(nullable=false, length=50)
	private String username;
	
	@Id // Indicates that id is the primary key 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	private String about;
	private String email;
	private String password;
}
