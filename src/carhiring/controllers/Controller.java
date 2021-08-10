package carhiring.controllers;

import carhiring.models.Model;
import carhiring.utils.SceneUpdater;
import carhiring.views.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Controller.java
 *
 * @version 1.0
 *
 * It represents the Controller in the
 * MVC design and architecture.
 *
 * It contains the model, view and updater in it
 * to do the actions in the project.
 */
public abstract class Controller implements EventHandler<ActionEvent> {

    // Attributes..
    private SceneUpdater updater;
    private Model model;
    private View view;

    /**
     * It will initialise all attributes.
     *
     * @param updater to change the view.
     * @param model current model of controller
     * @param view current view of controller
     */
    public Controller(SceneUpdater updater, Model model, View view) {

        this.updater = updater;
        this.model = model;
        this.view = view;
        getView().registerBTNActions(this);

    }

    /**
     * @return updater
     */
    public SceneUpdater getUpdater() {

        return updater;

    }

    /**
     * @return model
     */
    public Model getModel() {

        return model;

    }

    /**
     * @return view
     */
    public View getView() {

        return view;

    }

}
