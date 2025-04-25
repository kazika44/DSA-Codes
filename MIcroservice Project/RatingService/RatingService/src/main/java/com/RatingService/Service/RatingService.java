package com.RatingService.Service;

import com.RatingService.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RatingService {

    public Rating create(Rating rating);
    public List<Rating> getAllRating();
    List<Rating> getByUserId(String Userid);
    List<Rating> getByHotelId(String HotelId);
}
