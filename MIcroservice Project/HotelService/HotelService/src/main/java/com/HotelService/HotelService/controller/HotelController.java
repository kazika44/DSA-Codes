package com.HotelService.HotelService.controller;

import com.HotelService.HotelService.entities.Hotel;
import com.HotelService.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/hotels")
public class HotelController {
    @Autowired
    HotelService hotelservice;
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelservice.create(hotel));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel()
    {
        return ResponseEntity.ok().body(hotelservice.getAllHotels());
    }
    @GetMapping(path = "/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(hotelservice.getHotel(hotelId));
    }

}
