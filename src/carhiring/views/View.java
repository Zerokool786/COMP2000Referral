package carhiring.views;

import carhiring.controllers.Controller;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * View
 *
 * @version 1.0
 * <p>
 * It is an interface for View, which
 * has abstract method to use.
 */
public abstract class View {

    // Attributes..
    private Controller controller;
    private Group group; // To control the components.

    /**
     * Default Constructor.
     */
    public View() {

        group = new Group();
        initUI();

    }

    /**
     * @return controller for view
     */
    public Controller getController() {

        return controller;

    }

    /**
     * Set the new value for controller.
     *
     * @param controller new controller
     */
    public void setController(Controller controller) {

        this.controller = controller;

    }

    /**
     * @return group of view.
     */
    public Group getGroup() {

        return group;

    }

    // Helper methods..

    /**
     * It will add the component into
     * the group.
     *
     * @param component current field
     * @param x x-axis location of field
     * @param y y-axis location of field
     * @param width width of field
     * @param height height of field
     */
    public void include(Region component, int x, int y, int width, int height) {

        component.setLayoutX(x);
        component.setLayoutY(y);
        component.setPrefWidth(width);
        component.setPrefHeight(height);
        group.getChildren().add(component);

    }

    /**
     * It will add the component into
     * the group.
     *
     * @param component current field
     * @param x x-axis location of field
     * @param y y-axis location of field
     */
    public void include(Region component, int x, int y) {

        component.setLayoutX(x);
        component.setLayoutY(y);
        group.getChildren().add(component);

    }

    /**
     * Setting the new font for the label.
     *
     * @param label current component
     * @param size new size of label
     * @return label with implemented font.
     */
    public Label font(Label label, int size) {

        label.setFont(Font.font("Verdana", FontWeight.BOLD, size));
        return label;

    }

    /**
     * Creating the alert for the project.
     *
     * @param alertType of alert
     * @param content of alert
     */
    public void createAlert(Alert.AlertType alertType, String content) {

        Alert alert = new Alert(alertType);
        alert.setTitle("Car Hiring");
        alert.setContentText(content);
        alert.show();

    }

    // Abstract methods.

    /**
     * It will initialise the UI components
     * and make the scene ready to show up.
     */
    public abstract void initUI();

    /**
     * @return ready to use scene
     */
    public abstract Scene getScene();

    /**
     * It will add all of the Button listeners
     * to the controller.
     *
     * @param controller to register listeners.
     */
    public abstract void registerBTNActions(Controller controller);

}
