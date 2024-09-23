package org.services.hotels.hotelservice.repository;

import jakarta.persistence.EntityNotFoundException;
import org.services.hotels.hotelservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    default Optional<Hotel> findByName(String name) {
        Hotel hotel = findAll().stream()
                .filter(h -> h.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(new Hotel());
        return Optional.of(hotel);
    }
    default Optional<List<Hotel>> findByCountry(String country) {
        List<Hotel> hotel = findAll().stream()
                .filter(h -> h.getCountry().equalsIgnoreCase(country))
                .toList();
        return Optional.of(hotel);
    }
    default Optional<List<Hotel>> findByCity(String city) {
        List<Hotel> hotel = findAll().stream()
                .filter(h -> h.getCity().equalsIgnoreCase(city))
                .toList();
        return Optional.of(hotel);
    }
    default Optional<List<Hotel>> getByStars(int stars) {
        List<Hotel> hotel = findAll().stream()
                .filter(h -> h.getStars() == stars)
                .toList();
        return Optional.of(hotel);
    }
    default void deleteByName(String name) {
        if (findByName(name).isPresent()) {
            delete(findByName(name).get());
        }
    }
    default void updateByName(String name, Hotel hotel) {
        Hotel hotelToUpdate = findByName(name).orElseThrow(() -> new EntityNotFoundException("Hotel is not found"));
        hotelToUpdate.setName(hotel.getName());
        hotelToUpdate.setCountry(hotel.getCountry());
        hotelToUpdate.setCity(hotel.getCity());
        hotelToUpdate.setStars(hotel.getStars());
        hotelToUpdate.setAddress(hotel.getAddress());
        hotelToUpdate.setPhone(hotel.getPhone());
        save(hotelToUpdate);
    }
}
