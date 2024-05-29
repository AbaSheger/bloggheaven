package com.example.bloggheaven.Repository;

import com.example.bloggheaven.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //get all users
    //get user by id
    // create use

}
