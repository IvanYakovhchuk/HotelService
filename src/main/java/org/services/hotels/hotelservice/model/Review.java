package org.services.hotels.hotelservice.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private UUID id;

    private String comment;
    private String author;
    private int stars;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Review(String comment, UUID id, int stars, String author, Date date, Hotel hotel) {
        this.comment = comment;
        this.id = id;
        this.stars = stars;
        this.author = author;
        this.date = date;
        this.hotel = hotel;
    }

    public Review() {}

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
