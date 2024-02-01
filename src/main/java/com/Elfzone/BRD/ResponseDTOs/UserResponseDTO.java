package com.Elfzone.BRD.ResponseDTOs;

import java.util.UUID;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class UserResponseDTO {
    long registrationNumber;
    
    String userName;

    int age;

    String organisation;

    String emailId;

    String message;
}
