package carhiring.models.data;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

/**
 * Booking.java
 *
 * @version 1.0
 *
 * It represents the Booking object
 * in the program including its
 * functionalities.
 */
public class Booking implements Serializable {

    // Attributes..
    private Customer customer;
    private Car car;
    private LocalDate bookingDate;
    private LocalDate returnDate;
    private long totalDays;
    private double totalCost;
    // Filename..
    public static final String FILENAME = "bookings.ser";

    /**
     * It will initialise the booking attributes.
     *
     * @param customer doing booking
     * @param returnDate of booking
     */
    public Booking(Customer customer, LocalDate returnDate) {

        this.customer = customer;
        this.car = customer.getBookedCar();
        this.bookingDate = LocalDate.now();
        this.returnDate = returnDate;
        this.totalDays = Period.between(bookingDate, returnDate).getDays();
        this.totalCost = totalDays * customer.getBookedCar().getCostPerDay();

    }

    /**
     * @return customer of booking
     */
    public Customer getCustomer() {

        return customer;

    }

    /**
     * @return booking date of booking
     */
    public LocalDate getBookingDate() {

        return bookingDate;

    }

    /**
     * @return return date of booking
     */
    public LocalDate getReturnDate() {

        return returnDate;

    }

    /**
     * @return total days of booking
     */
    public long getTotalDays() {

        return totalDays;

    }

    /**
     * @return total cost of booking
     */
    public double getTotalCost() {

        return totalCost;

    }

    /**
     * @return booked car
     */
    public Car getCar() {

        return car;

    }

}
