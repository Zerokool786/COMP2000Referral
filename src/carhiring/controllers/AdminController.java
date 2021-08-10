package carhiring.controllers;

import carhiring.models.Model;
import carhiring.utils.SceneUpdater;
import carhiring.views.View;
import javafx.event.ActionEvent;

public class AdminController extends Controller {

    /**
     * It will initialise all attributes.
     *
     * @param updater to change the view.
     * @param model   current model of controller
     * @param view    current view of controller
     */
    public AdminController(SceneUpdater updater, Model model, View view) {

        super(updater, model, view);

    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }

}
