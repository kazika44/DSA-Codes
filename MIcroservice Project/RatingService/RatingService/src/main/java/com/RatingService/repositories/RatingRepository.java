package com.RatingService.repositories;

import com.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String> {
    List<Rating> findAllByUserId(String userId);
    List<Rating> findAllByHotelId(String hotelId);

}
