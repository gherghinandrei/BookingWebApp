package com.Andrei.BookingDemo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    private List<HotelBooking> bookingList;


    public BookingController(){
        this.bookingList = new ArrayList<>();

        bookingList.add(new HotelBooking("Marriot",200.5,3));
        bookingList.add(new HotelBooking("Iris",90,4));
        bookingList.add(new HotelBooking("Novotel",105.99,6));

    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<HotelBooking> getAllHotelBookings(){
        return bookingList;
    }


    @RequestMapping(value = "affordable/{price}",method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price){

        return this.bookingList.stream().filter(x -> x.getPricePerNight() < price)
                .collect(Collectors.toList());
    }


    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
        bookingList.add(hotelBooking);
        return bookingList;
    }


}
