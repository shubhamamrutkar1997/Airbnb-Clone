package com.AirbnbClone.AirbnbClone.Service;

import com.AirbnbClone.AirbnbClone.Entity.Booking;
import com.AirbnbClone.AirbnbClone.Entity.Property;
import com.AirbnbClone.AirbnbClone.Repository.BookingRepository;
import com.AirbnbClone.AirbnbClone.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PropertyRepository propertyRepository;


    /**
     * params propertyID
     * params startDate
     * params endDate
     * return param booking object
     */

    //save the booking
    public Booking createBooking(Long propertyId, LocalDate startDate, LocalDate endDate)
    {
        // This will check if the selected property is available. if yes, return else throw property not found.
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(()-> new RuntimeException("Property Not Found"));

        // If not, create and save a new booking.
        Booking booking = new Booking();
        booking.setProperty(property);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);

        return bookingRepository.save(booking);
    }

    //get All the bookings.
    public List<Booking> getAllbookings(Long propertyId)
    {
        return bookingRepository.findAll();
    }

    //get booking by propertyId
    public List<Booking> getBookingByProperty(Long propertyId)
    {
        return bookingRepository.findByPropertyById(propertyId);
    }

    //delete the booking by id
    public void deleteBooking(Long id)
    {
        bookingRepository.deleteById(id);
    }
}
