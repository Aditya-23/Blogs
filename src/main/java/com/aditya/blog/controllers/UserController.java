package com.aditya.blog.controllers;


import com.aditya.blog.payloads.ApiResponse;
import com.aditya.blog.payloads.UserDto;
import com.aditya.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Controllers - where the URLs first hit -> API end points
@RestController
@RequestMapping("/api/users") // URL with /api/users will be mapped to this controller
public class UserController {
    @Autowired
    private UserService userServiceObj;
    public UserController(UserService userServiceObj) {
        this.userServiceObj = userServiceObj;
    }

    //Post request to /api/users/ will create a user entity using the below method
    @PostMapping("/")
    private ResponseEntity<UserDto> createUserRoute(@RequestBody UserDto userDtoObj){
        UserDto createdUserDtoObj = this.userServiceObj.createUser(userDtoObj);
        return new ResponseEntity<UserDto>(createdUserDtoObj, HttpStatus.CREATED);
    }

    // update user by id
    @PutMapping("/{userId}")
    private ResponseEntity<UserDto> updateUserRoute(@RequestBody UserDto userDtoObj, @PathVariable int userId){
        UserDto updatedUserDtoObj = this.userServiceObj.updateUser(userDtoObj, userId);
        return new ResponseEntity<>(updatedUserDtoObj, HttpStatus.CREATED);
    }

    // Get user by id
    @GetMapping("{userId}")
    private ResponseEntity<UserDto> getUserById(@PathVariable int userId){
        UserDto userDtoObj = this.userServiceObj.getUserById(userId);
        return ResponseEntity.ok(userDtoObj);
    }

    // Delete a user by id
    @DeleteMapping("/{userId}")
    private ResponseEntity<ApiResponse> deleteUserById(@PathVariable int userId){
        this.userServiceObj.deleteUser(userId);
        return ResponseEntity.ok(new ApiResponse("Delete Successfully", true));
    }
}
