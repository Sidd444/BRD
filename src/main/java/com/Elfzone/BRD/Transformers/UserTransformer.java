package com.Elfzone.BRD.Transformers;

import com.Elfzone.BRD.Models.User;
import com.Elfzone.BRD.RequestDTOs.UserRequestDTO;
import com.Elfzone.BRD.ResponseDTOs.UserResponseDTO;

public class UserTransformer{
    public static User UserRequestDtoToUser(UserRequestDTO userRequestDTO) {
        return User.builder()
        .userName(userRequestDTO.getUserName())
        .age(userRequestDTO.getAge())
        .organisation(userRequestDTO.getOrganisation())
        .registrationNumber(userRequestDTO.getRegistrationNumber())
        .emailId(userRequestDTO.getEmailId())
        .password(userRequestDTO.getPassword())
        .build();
    }
    public static UserResponseDTO UserToUserResponseDto(User savedUser){
        return UserResponseDTO.builder()
        .userName(savedUser.getUserName())
        .age(savedUser.getAge())
        .organisation(savedUser.getOrganisation())
        .emailId(savedUser.getEmailId())
        .registrationNumber(savedUser.getRegistrationNumber())
        .message(savedUser.getUserName()+" with registration no. "+savedUser.getRegistrationNumber()+" has been added successfully")
        .build();
    }
}