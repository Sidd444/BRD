package com.Elfzone.BRD.RequestDTOs;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class UserRequestDTO {
    String userName;

    int age;

    String organisation;

    int registrationNumber;

    String emailId;

    String password;

}
