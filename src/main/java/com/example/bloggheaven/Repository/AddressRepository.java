package com.example.bloggheaven.Repository;

import com.example.bloggheaven.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    //get all address
    //get address by id
    // create address
    //update address
    //delete address

 // List<Address> findAll();

  //Optional<Address> findById(Long id);

  //Address save(Address address);

  //Address update(Address address);

  //void delete(Address address);

}
