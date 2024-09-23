package org.services.hotels.hotelservice.repository;

import org.services.hotels.hotelservice.model.Hotel;
import org.services.hotels.hotelservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    default Optional<List<Review>> findByHotel(Hotel hotel) {
        return Optional.of(findAll().stream()
                .filter(review -> review.getHotel().equals(hotel))
                .toList());
    }
}
