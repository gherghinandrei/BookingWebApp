package com.Andrei.BookingDemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    BookingRepository bookingRepository;


    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<HotelBooking> getAllHotelBookings(){

        return  bookingRepository.findAll();
    }


    @RequestMapping(value = "affordable/{price}",method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price){
        return this.bookingRepository.findByPricePerNightLessThan(price);
    }


    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
        this.bookingRepository.save(hotelBooking);
        return this.bookingRepository.findAll();

    }

    @RequestMapping(value = "delete/{id}", method =RequestMethod.GET)
    public List<HotelBooking> delete(@PathVariable long id){
        this.bookingRepository.deleteById(id);
        return this.bookingRepository.findAll();
    }



}
