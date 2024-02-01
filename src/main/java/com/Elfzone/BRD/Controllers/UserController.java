package com.Elfzone.BRD.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Elfzone.BRD.Exceptions.UserNotFoundException;
import com.Elfzone.BRD.RequestDTOs.UserRequestDTO;
import com.Elfzone.BRD.ResponseDTOs.UserResponseDTO;
import com.Elfzone.BRD.Services.UserService;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    UserService userService;
    
    @PostMapping("/add")
    public ResponseEntity createUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO=userService.createUser(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO,HttpStatus.CREATED);
    }
    @GetMapping("get-user-by-emailId")
    public ResponseEntity getUserById(@RequestParam String email){
        try{
            UserResponseDTO user=userService.getUserByEmail(email);
            return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
        }
        catch(UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity getAllUserInfo(){
        List<UserResponseDTO> users=userService.getAllUsersInformation();
        return new ResponseEntity<>(users,HttpStatus.ACCEPTED);
    }
}