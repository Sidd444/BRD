package com.Elfzone.BRD.Models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

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
    long registrationNumber;

    String userName;

    int age;

    String organisation;

    @Column(unique = true,nullable = false)
    String emailId;

    String password;

    

}
