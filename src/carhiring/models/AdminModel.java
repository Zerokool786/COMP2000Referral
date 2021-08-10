package carhiring.models;

import carhiring.models.data.Booking;
import carhiring.models.data.Car;
import carhiring.models.data.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * AdminModel.java
 *
 * @version 1.0
 *
 * It represents the model of the admin
 * panel and contains all of the data required
 * to view on controller.
 */
public class AdminModel extends Model {

    // Attributes..
    private List<Car> carList;
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
            bookingList = (List<Booking>) readData(Booking.FILENAME);
        } catch (Exception e) {
            bookingList = new ArrayList<>();
        }

    }

    /**
     * It will add a new car into the
     * database.
     *
     * @param car to add
     */
    public void addCar(Car car) {

        carList.add(car);
        updateCarDetails();

    }

    /**
     * It will update the previous car data.
     *
     * @param index of current car
     * @param selectedCar new updated car
     */
    public void updateCar(int index, Car selectedCar) {

        if (index >= 0 && index < carList.size()) {
            carList.set(index, selectedCar);
            updateCarDetails();
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
     * @return list of bookings.
     */
    public List<Booking> getBookingList() {

        return bookingList;

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
