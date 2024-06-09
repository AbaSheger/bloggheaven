package com.example.bloggheaven.services;

import com.example.bloggheaven.Repository.AddressRepository;
import com.example.bloggheaven.Repository.UserRepository;
import com.example.bloggheaven.entity.Address;
import com.example.bloggheaven.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

   public User save(User user) {
        Address address = user.getAddress();
        if (address != null && address.getId() != null){
            Optional<Address> optionalAddress = addressRepository.findById(address.getId());
            if (optionalAddress.isPresent()) {
                address = optionalAddress.get();
            } else {
                address = addressRepository.save(address);
            }

        } else if (address != null && address.getId() == null) {
            address = addressRepository.save(address);
        }
        user.setAddress(address);

        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

}