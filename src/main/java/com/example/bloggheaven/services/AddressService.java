package com.example.bloggheaven.services;

import com.example.bloggheaven.Repository.AddressRepository;
import com.example.bloggheaven.Repository.UserRepository;
import com.example.bloggheaven.entity.Address;
import com.example.bloggheaven.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;


@Service
public class AddressService {


   private final AddressRepository addressRepository;
   private final UserRepository userRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository , UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;

    }


    public List<Address> findAll() {
        return addressRepository.findAll();
    }




    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
    }



    public Address save(Address address, Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));



        address.setUsers(Arrays.asList(user));

        return addressRepository.save(address);
    }



    public Address update(Address address) {
        return addressRepository.save(address);
    }


    public void delete(Address address) {
        addressRepository.delete(address);
    }


}
