package org.services.hotels.hotelservice.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
public class Hotel {
    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    private String country;
    private String city;
    private String address;
    private String phone;
    private int stars;
    @OneToMany(mappedBy = "hotel",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private List<Review> reviews;

    public Hotel() {}

    public Hotel(UUID id, int stars, String phone, String address, String city, String country, String name) {
        this.id = id;
        this.stars = stars;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Hotel name: " + getName() + "\n" +
                "Country: " + getCountry() + "\n" +
                "City: " + getCity() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Phone: " + getPhone() + "\n" +
                "Stars: " + getStars() + "\n";
    }
}
