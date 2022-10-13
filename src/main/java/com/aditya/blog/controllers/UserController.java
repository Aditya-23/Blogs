package com.aditya.blog.controllers;


import com.aditya.blog.payloads.UserDto;
import com.aditya.blog.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Controllers - where the URLs first hit -> API end points
@RestController
@RequestMapping("/api/users") // URL with /api/users will be mapped to this controller
public class UserController {

    private UserService userServiceObj;

    //Post request to /api/users/ will create a user entity using the below method
    @PostMapping("/")
    private ResponseEntity<UserDto> createUser(@RequestBody UserDto userDtoObj){
        UserDto createdUserDtoObj = this.userServiceObj.createUser(userDtoObj);
        return new ResponseEntity<UserDto>(createdUserDtoObj, HttpStatus.CREATED);
    }
}
