package com.Andrei.BookingDemo;

public class HotelBooking {
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
}
