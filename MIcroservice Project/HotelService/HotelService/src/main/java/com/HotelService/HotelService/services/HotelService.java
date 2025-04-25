package com.HotelService.HotelService.services;

import com.HotelService.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel create(Hotel hotel);
    public List<Hotel> getAllHotels();
    public Hotel getHotel(String id);

}
