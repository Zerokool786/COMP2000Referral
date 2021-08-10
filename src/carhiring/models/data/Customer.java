package carhiring.models.data;

import java.io.Serializable;

/**
 * Customer.java
 *
 * @version 1.0
 *
 * It represents the Customer object
 * in the program including its
 * functionalities.
 */
public class Customer implements Serializable {

    // Attributes..
    private String name;
    private String address;
    private String drivingLicenseNumber;
    private Car bookedCar;
    // Filename..
    public static final String FILENAME = "customers.ser";

    /**
     * It will initialise the attributes.
     *
     * @param name of customer
     * @param address of customer
     * @param drivingLicenseNumber of customer
     * @param bookedCar of customer
     */
    public Customer(String name, String address, String drivingLicenseNumber, Car bookedCar) {

        this.name = name;
        this.address = address;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.bookedCar = bookedCar;

    }

    /**
     * @return name of customer
     */
    public String getName() {

        return name;

    }

    /**
     * @return address of customer
     */
    public String getAddress() {

        return address;

    }

    /**
     * @return driving license of customer
     */
    public String getDrivingLicenseNumber() {

        return drivingLicenseNumber;

    }

    /**
     * @return booked car for customer
     */
    public Car getBookedCar() {

        return bookedCar;

    }

    @Override
    public String toString() {

        return name;

    }

}
