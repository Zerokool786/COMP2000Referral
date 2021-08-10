package carhiring.models.data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Car.java
 *
 * @version 1.0
 *
 * It represents the Car object
 * in the program including its
 * functionalities.
 */
public class Car implements Serializable {

    // Attributes..
    private String name;
    private double costPerDay;
    private boolean available;
    private LocalDate carAvailableDate;
    private String availableStatus;
    // Filename..
    public static final String FILENAME = "cars.ser";

    /**
     * It will initialise the attributes.
     *
     * @param name of car
     * @param costPerDay of car
     */
    public Car(String name, double costPerDay) {

        this.name = name;
        this.costPerDay = costPerDay;
        available = true;
        this.availableStatus = "Yes";

    }

    /**
     * @return name of car
     */
    public String getName() {

        return name;

    }

    /**
     * @return cost per day of car
     */
    public double getCostPerDay() {

        return costPerDay;

    }

    /**
     * Setting the new data.
     *
     * @param costPerDay  of car
     */
    public void setCostPerDay(double costPerDay) {

        this.costPerDay = costPerDay;

    }

    /**
     * @return true if available else false
     */
    public boolean isAvailable() {

        return available;

    }

    /**
     * @return status of availability
     */
    public String getAvailableStatus() {

        return availableStatus;

    }

    /**
     * Setting the new data.
     *
     * @param available of car
     */
    public void setAvailable(boolean available) {

        this.available = available;
        this.availableStatus = available ? "Yes" : "No";

    }

    /**
     * @return available date
     */
    public LocalDate getCarAvailableDate() {

        return carAvailableDate;

    }

    /**
     * Setting the new data.
     *
     * @param carAvailableDate of car
     */
    public void setCarAvailableDate(LocalDate carAvailableDate) {

        this.carAvailableDate = carAvailableDate;

    }

    @Override
    public String toString() {

        return name;

    }

}
