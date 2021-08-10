package carhiring.controllers;

import carhiring.models.LoginModel;
import carhiring.models.Model;
import carhiring.models.data.AdminLogin;
import carhiring.utils.SceneType;
import carhiring.utils.SceneUpdater;
import carhiring.views.LoginView;
import carhiring.views.View;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * LoginController.java
 *
 * @version 1.0
 *
 * It creates a controller for the login.
 */
public class LoginController extends Controller {

    /**
     * It will initialise all attributes.
     *
     * @param updater to change the view.
     * @param model   current model of controller
     * @param view    current view of controller
     */
    public LoginController(SceneUpdater updater, Model model, View view) {

        super(updater, model, view);

    }

    /**
     * Handling all actions of buttons here.
     * @param actionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {

        Button button = (Button) actionEvent.getSource();
        switch (button.getId()) {

            // When admin login button is clicked.
            case "ADMIN_LOGIN":
                // It will open the admin panel if username
                // and password is correct, else it will give error.
                LoginView view = (LoginView) getView();
                AdminLogin admin = ((LoginModel) getModel()).getAdmin();
                String username = view.getUsernameField().getText();
                String password = view.getPasswordField().getText();
                if(username.equals(admin.getUsername()) &&
                    password.equals(admin.getPassword())) {
                    getUpdater().updateControllerSceneType(SceneType.MAIN_ADMIN);
                } else {
                    getView().createAlert(Alert.AlertType.ERROR, "Username or Password is wrong.");
                }
                break;
            case "CUSTOMER_ACCESS":
                // Accessing the customer control right now.
                getUpdater().updateControllerSceneType(SceneType.MAIN_CUSTOMER);
                break;

        }

    }

}
