package com.Elfzone.BRD.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Elfzone.BRD.Exceptions.EmailAlreadyExistsException;
import com.Elfzone.BRD.Exceptions.UserNotFoundException;
import com.Elfzone.BRD.Models.User;
import com.Elfzone.BRD.Repositories.UserRepository;
import com.Elfzone.BRD.RequestDTOs.UserRequestDTO;
import com.Elfzone.BRD.ResponseDTOs.UserResponseDTO;
import com.Elfzone.BRD.Transformers.UserTransformer;

import java.util.List;
import java.util.Optional;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) throws EmailAlreadyExistsException{
        User userEmail=userRepository.findByEmailId(userRequestDTO.getEmailId());
        if(userEmail!=null) throw new EmailAlreadyExistsException("Email is Already Present");
        User user=UserTransformer.UserRequestDtoToUser(userRequestDTO);
        User savedUser=userRepository.save(user);
        return UserTransformer.UserToUserResponseDto(savedUser);
    }
    public UserResponseDTO getUserByEmail(String email) throws UserNotFoundException{
        User user=userRepository.findByEmailId(email);
        if(user==null) throw new UserNotFoundException("invalid email id");
        return UserTransformer.UserToUserResponseDto(user);
    }
    public List<UserResponseDTO> getAllUsersInformation(){
        List<User> users=userRepository.findAll();
        List<UserResponseDTO> userInfo=new ArrayList<>();
        for(User u:users){
            userInfo.add(UserTransformer.UserToUserResponseDto(u));
        }
        return userInfo;
    }
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO) throws UserNotFoundException{
        User user=userRepository.findByEmailId(userRequestDTO.getEmailId());
        if(user==null) throw new UserNotFoundException("Invalid email id");
        User savedUser=userRepository.save(user);
        return UserTransformer.UserToUserResponseDto(savedUser);
    }
    public boolean deleteUser(String emailId) throws UserNotFoundException{
        User user=userRepository.findByEmailId(emailId);
        if(user==null) throw new UserNotFoundException("User Does Not Exists");
        userRepository.delete(user);
        return true;
    }
}
