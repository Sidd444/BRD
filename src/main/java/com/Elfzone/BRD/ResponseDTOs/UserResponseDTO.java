package com.Elfzone.BRD.ResponseDTOs;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class UserResponseDTO {
    String userName;

    int age;

    String organisation;
  
    int registrationNumber;

    String emailId;

    String message;
}
