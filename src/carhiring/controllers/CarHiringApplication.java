package carhiring.controllers;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * CarHiringController
 *
 * @version 1.0
 * <p>
 * It is the Main Controller and only
 * one Application class which has the
 * responsibility to handle all stages and
 * scenes of the program.
 */
public class CarHiringApplication extends Application {

    // Attributes..
    private Group root;

    /**
     * To initialise the stage and
     * scenes including its components.
     *
     * @param primaryStage main stage of application.
     * @throws Exception if any issue occur in initialising
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Initialising the stage.
        root = new Group();
        primaryStage.setTitle("Car Hiring Program");
        primaryStage.setScene(new Scene(root, 900, 700));

        // Start the program.
        primaryStage.show();

    }

}