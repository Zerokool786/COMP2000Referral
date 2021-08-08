package carhiring;

import carhiring.controllers.CarHiringController;
import javafx.application.Application;

/**
 * CarHiringRunner.java
 *
 * @version 1.0
 *
 * It is the main class to start
 * the execution of the program.
 */
public class CarHiringRunner {

    /**
     * Main method to start program execution.
     *
     * @param args console based parameters.
     */
    public static void main(String[] args) {

        // Executing the program.
        Application.launch(CarHiringController.class, args);

    }

}
