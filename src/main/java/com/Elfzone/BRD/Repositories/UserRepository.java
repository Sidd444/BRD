package com.Elfzone.BRD.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Elfzone.BRD.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    public User findByEmailId(String email);
}
