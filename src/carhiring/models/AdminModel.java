package carhiring.models;

import carhiring.models.data.Booking;
import carhiring.models.data.Car;
import carhiring.models.data.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    private void updateCarDetails() {

        try {
            saveData(Car.FILENAME, carList);
        } catch (IOException e) {
            // unable to write the data to file.
        }

    }

}
