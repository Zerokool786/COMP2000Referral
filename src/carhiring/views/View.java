package carhiring.views;

import carhiring.controllers.Controller;
import javafx.scene.Scene;

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

    /**
     * Default Constructor.
     */
    public View() {

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

}
