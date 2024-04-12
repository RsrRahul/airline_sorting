package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.model.Airline;
import com.example.springboot.service.AirlineService;

import java.util.List;

@RestController
@RequestMapping("/api/airline") 
public class AirlineController {

    @Autowired
    private AirlineService airlineService; 

    @PostMapping 
    public ResponseEntity<Airline> addAirline(@RequestBody Airline airline) {
        Airline newAirline = airlineService.create(airline);
        return new ResponseEntity<>(newAirline, HttpStatus.CREATED);
    }

    @GetMapping 
    public ResponseEntity<List<Airline>> getAllAirlines() {
        List<Airline> airlines = airlineService.getAllAirlines();
        return new ResponseEntity<>(airlines, HttpStatus.OK);
    }

    @GetMapping("/{id}") 
    public ResponseEntity<Airline> getAirlineById(@PathVariable("id") int id) {
        Airline airline = airlineService.getAirlineById(id).orElse(null);
        if (airline != null) {
            return new ResponseEntity<>(airline, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}") // No changes needed here
    public ResponseEntity<Airline> updateAirline(@PathVariable("id") int id, @RequestBody Airline airline) {
        if (airlineService.updateAirline(id, airline)) {
            return new ResponseEntity<>(airline, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}") // No changes needed here
    public ResponseEntity<Boolean> deleteAirline(@PathVariable("id") int id) {
        if (airlineService.deleteAirline(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/sorted") // No changes needed here
    public ResponseEntity<List<Airline>> getAllAirlinesSorted(@RequestParam String sortBy) {
        List<Airline> airlines = airlineService.getAllAirlinesSortedBy(sortBy);
        return new ResponseEntity<>(airlines, HttpStatus.OK);
    }

    @GetMapping("/page") // No changes needed here
    public ResponseEntity<Page<Airline>> getAllAirlinesPaginated(@RequestParam int pageNo, @RequestParam int pageSize) {
        Page<Airline> airlinesPage = airlineService.getAllAirlinesPaginated(pageNo, pageSize);
        return new ResponseEntity<>(airlinesPage, HttpStatus.OK);
    }
    
    @GetMapping("/name/{airlineName}") // No changes needed here
    public ResponseEntity<List<Airline>> getAirlinesByAirlineName(@PathVariable String airlineName) {
        List<Airline> airlines = airlineService.findByAirlineName(airlineName);
        return new ResponseEntity<>(airlines, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}") // No changes needed here
    public ResponseEntity<List<Airline>> getAirlinesByUserId(@PathVariable int userId) {
        List<Airline> airlines = airlineService.findByUserId(userId);
        return new ResponseEntity<>(airlines, HttpStatus.OK);
    }
}