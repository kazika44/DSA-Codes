package com.HotelService.HotelService.services.Impl;

import com.HotelService.HotelService.entities.Hotel;
import com.HotelService.HotelService.exception.ResourceNotFoundException;
import com.HotelService.HotelService.repositories.HotelRepository;
import com.HotelService.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        String id= UUID.randomUUID().toString();
        hotel.setHotelId(id);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Hotel with id: "+id+ "not found on the Server!!"));
    }
}
