package com.example.springboot.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String airlineName;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL)
    private List<User> users;

    // Constructors, getters, and setters
    public Airline() {
    }

    public Airline(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}