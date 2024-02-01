package com.Elfzone.BRD.RequestDTOs;

import java.util.UUID;

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

    String emailId;

    String password;

}
