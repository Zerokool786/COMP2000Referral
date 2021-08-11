package carhiring.models;

import carhiring.models.data.Booking;
import carhiring.models.data.Car;
import carhiring.models.data.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CustomerModel.java
 *
 * @version 1.0
 *
 * It represents the model for the
 * customer related data
 */
public class CustomerModel extends Model {

    // Attributes..
    private List<Car> carList;
    private List<Customer> customerList;
    private List<Booking> bookingList;

    @Override
    public void initData() {

        // Initialising the data from files.
        try {
            carList = (List<Car>) readData(Car.FILENAME);
        } catch (Exception e) {
            carList = new ArrayList<>();
        }

        try {
            customerList = (List<Customer>) readData(Customer.FILENAME);
        } catch (Exception e) {
            customerList = new ArrayList<>();
        }

        try {
            bookingList = (List<Booking>) readData(Booking.FILENAME);
        } catch (Exception e) {
            bookingList = new ArrayList<>();
        }

    }

    /**
     * @return list of available cars
     */
    public List<Car> getAvailableCars() {

        List<Car> list = new ArrayList<>();
        for (Car car: carList) {
            if (car.isAvailable()) {
                list.add(car);
            }
        }
        return list;

    }

    /**
     * To add the customer booking in
     * the database.
     *
     * @param index of car
     * @param customer booking
     *
     * @return booking done.
     */
    public Booking addCustomerBooking(int index, Customer customer) {

        if (index < 0 || index > carList.size()) {
            return null;
        }
        Booking booking = new Booking(customer, customer.getBookedCar().getCarAvailableDate());
        this.carList.set(index, customer.getBookedCar());
        this.customerList.add(customer);
        this.bookingList.add(booking);
        this.updateCarDetails();
        this.updateCustomerDetails();
        this.updateBookingDetails();
        return booking;

    }

    /**
     * Updating the customer details.
     */
    private void updateCustomerDetails() {

        try {
            saveData(Customer.FILENAME, customerList);
        } catch (IOException e) {
            // unable to write the data to file.
        }

    }

    /**
     * Updating the booking details.
     */
    private void updateBookingDetails() {

        try {
            saveData(Booking.FILENAME, bookingList);
        } catch (IOException e) {
            // unable to write the data to file.
        }

    }

    /**
     * Updating the car details.
     */
    private void updateCarDetails() {

        try {
            saveData(Car.FILENAME, carList);
        } catch (IOException e) {
            // unable to write the data to file.
        }

    }

}
