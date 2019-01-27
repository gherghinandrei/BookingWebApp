package com.Andrei.BookingDemo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String hotelName;
    private double pricePerNight;
    private int noOfNights;

    public HotelBooking(){}

    public HotelBooking(String hotelName, double pricePerNight, int noOfNights) {
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.noOfNights = noOfNights;
    }


    public String getHotelName() {
        return hotelName;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNoOfNights() {
        return noOfNights;
    }


    public double totalPrice(){
        return this.noOfNights * this.pricePerNight;
    }

    public long getId() {
        return id;
    }
}
