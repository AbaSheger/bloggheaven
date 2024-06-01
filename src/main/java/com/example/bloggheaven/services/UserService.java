package com.example.bloggheaven.services;

import com.example.bloggheaven.Repository.AddressRepository;
import com.example.bloggheaven.Repository.UserRepository;
import com.example.bloggheaven.entity.Address;
import com.example.bloggheaven.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//get all users
//get user by id
// create user
//update user
//delete user



@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public UserService(UserRepository userRepository , AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


    public User save(User user) {

        Address address = user.getAddress();
        if (address != null) {
            if (address.getId() != null && !addressRepository.existsById(address.getId())) {
                throw new RuntimeException("Address with id " + address.getId() + " not found");
            } else if (address.getId() != null) {
                address = addressRepository.findById(address.getId()).get();
            } else {
                address = addressRepository.save(address);
            }
            user.setAddress(address);
        }

        return userRepository.save(user);

    }


    public User update(User user) {
        return userRepository.save(user);
    }


    public void delete(User user) {
        userRepository.delete(user);
    }

}
