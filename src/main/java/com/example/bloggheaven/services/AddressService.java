package com.example.bloggheaven.services;

import com.example.bloggheaven.Repository.AddressRepository;
import com.example.bloggheaven.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {


   private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;

    }

    //get all address

    public List<Address> findAll() {
        return addressRepository.findAll();
    }


    //get address by id

    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }


    // create address

    public Address save(Address address) {
        return addressRepository.save(address);
    }


    //update address

    public Address update(Address address) {
        return addressRepository.save(address);
    }

    //delete address

    public void delete(Address address) {
        addressRepository.delete(address);
    }


}
