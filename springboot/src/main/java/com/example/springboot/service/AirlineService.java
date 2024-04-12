package com.example.springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.springboot.model.Airline;
import com.example.springboot.repository.AirlineRepo;

@Service
public class AirlineService {

    @Autowired
    AirlineRepo airlineRepository;

    public Airline create(Airline airline) {
        return airlineRepository.save(airline);
    }

    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    public Optional<Airline> getAirlineById(int id) {
        return airlineRepository.findById(id);
    }

    public boolean updateAirline(int id, Airline airline) {
        if (!airlineRepository.existsById(id)) {
            return false;
        }
        airline.setId(id);
        airlineRepository.save(airline);
        return true;
    }

    public boolean deleteAirline(int id) {
        if (!airlineRepository.existsById(id)) {
            return false;
        }
        airlineRepository.deleteById(id);
        return true;
    }

    public List<Airline> getAllAirlinesSortedBy(String sortBy) {
        return airlineRepository.findAll(Sort.by(sortBy));
    }

    public Page<Airline> getAllAirlinesPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return airlineRepository.findAll(pageable);
    }
    
    public List<Airline> findByAirlineName(String airlineName) {
        return airlineRepository.findByAirlineName(airlineName);
    }

    public List<Airline> findByUserId(int userId) {
        return airlineRepository.findByUserId(userId);
    }
}