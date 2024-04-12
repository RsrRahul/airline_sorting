package com.example.springboot.repository;

import com.example.springboot.model.Airline; // Update import to Airline
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AirlineRepo extends JpaRepository<Airline, Integer> { 

    @Query("SELECT a FROM Airline a WHERE a.airlineName = ?1") 
    List<Airline> findByAirlineName(String airlineName); 
    
    @Query("SELECT a FROM Airline a WHERE a.id IN (SELECT DISTINCT a.id FROM Airline a INNER JOIN a.users u WHERE u.id = ?1)") 
    List<Airline> findByUserId(int userId); 
}