package com.Andrei.BookingDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private BookingRepository bookingRepository;


    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<HotelBooking> bookingList = new ArrayList<>();

        bookingList.add(new HotelBooking("Marriot",200.5,3));
        bookingList.add(new HotelBooking("Iris",90,4));
        bookingList.add(new HotelBooking("Novotel",105.99,6));

        bookingRepository.saveAll(bookingList);


    }
}
