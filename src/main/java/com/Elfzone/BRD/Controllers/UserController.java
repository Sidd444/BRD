package com.Elfzone.BRD.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Elfzone.BRD.Exceptions.EmailAlreadyExistsException;
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
        try{
            UserResponseDTO userResponseDTO=userService.createUser(userRequestDTO);
            return new ResponseEntity<>(userResponseDTO,HttpStatus.CREATED);
        }
        catch(EmailAlreadyExistsException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("get-user-by-emailId")
    public ResponseEntity getUserById(@RequestParam String email){
        try{
            UserResponseDTO user=userService.getUserByEmail(email);
            String userInfo="Name:"+user.getUserName()+"Organisation:"+user.getOrganisation()+"Registration No:"+user.getRegistrationNumber();
            return new ResponseEntity<>(userInfo,HttpStatus.ACCEPTED);
        }
        catch(UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-All-Users")
    public ResponseEntity getAllUserInfo(){
        List<UserResponseDTO> users=userService.getAllUsersInformation();
        return new ResponseEntity<>(users,HttpStatus.ACCEPTED);
    }
    @PutMapping("/update-user-using-emailId")
    public ResponseEntity updateUser(UserRequestDTO userRequestDTO){
        try{
            UserResponseDTO userResponseDTO=userService.updateUser(userRequestDTO);
            String userInfo="User with emailId "+userRequestDTO.getEmailId()+" has been updated";
            return new ResponseEntity<>(userInfo,HttpStatus.ACCEPTED);
        }
        catch(UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("delete-user-by-emailId")
    public ResponseEntity deleteUser(String emailId){
        try{
            userService.deleteUser(emailId);
            return new ResponseEntity<>("User with emailId "+emailId+" has been deleted.",HttpStatus.ACCEPTED);
        }
        catch(UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}