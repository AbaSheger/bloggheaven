package com.example.bloggheaven.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "addresses")
public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "street", nullable = false, length = 100 )
    private String street;

    @Column (name = "postal_code", nullable = false, length = 10)
    private String postalCode;

    @Column (name = "city", nullable = false, length = 50)
    private String city;

    @Column (name = "country", nullable = false, length = 50)
    private String country;

    @OneToMany (mappedBy = "address", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("address")
    private List<User> users;


    public Address() {
    }


    public Address(String street, String postalCode, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
