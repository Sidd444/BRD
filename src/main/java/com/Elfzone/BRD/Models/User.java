package com.Elfzone.BRD.Models;

import lombok.*;
import lombok.experimental.FieldDefaults;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String userName;

    int age;

    String organisation;

    @Column(unique = true)
    int registrationNumber;

    @Column(unique = true)
    String emailId;

    String password;

    

}
