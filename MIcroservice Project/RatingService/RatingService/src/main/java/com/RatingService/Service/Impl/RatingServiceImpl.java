package com.RatingService.Service.Impl;

import com.RatingService.Service.RatingService;
import com.RatingService.entities.Rating;
import com.RatingService.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepository ratingRepository;
    @Override
    public Rating create(Rating rating) {
        rating.setRatingId(UUID.randomUUID().toString());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getByUserId(String Userid) {
        return ratingRepository.findAllByUserId(Userid);
    }

    @Override
    public List<Rating> getByHotelId(String HotelId) {
        return ratingRepository.findAllByHotelId(HotelId);
    }
}
