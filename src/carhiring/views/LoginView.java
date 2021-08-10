package carhiring.views;

import carhiring.controllers.Controller;
import carhiring.controllers.LoginController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * LoginView.java
 *
 * @version 1.0
 *
 * It creates a view for the login.
 */
public class LoginView extends View {

    // Attributes..
    private Scene scene;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button adminLoginButton;
    private Button customerAccessButton;

    @Override
    public void initUI() {

        scene = new Scene(getGroup(), 500, 300);

        // init..
        usernameField = new TextField();
        passwordField = new PasswordField();
        adminLoginButton = new Button("Admin Login");
        customerAccessButton = new Button("Customer Access");

        // setting colors.
        adminLoginButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        customerAccessButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");

        // Setting ids.
        adminLoginButton.setId("ADMIN_LOGIN");
        customerAccessButton.setId("CUSTOMER_ACCESS");

        // Setting the panels and placing the data.
        GridPane loginControls = new GridPane();
        loginControls.setVgap(10);
        loginControls.setHgap(20);
        loginControls.setAlignment(Pos.CENTER);

        loginControls.add(new Label("Enter Username"), 0, 0);
        loginControls.add(new Label("Enter Password"), 0, 1);
        loginControls.add(usernameField, 1, 0);
        loginControls.add(passwordField, 1, 1);
        loginControls.add(adminLoginButton, 0, 2);

        // Including the components into the view.
        include(font(new Label("User Authentication"), 18), 150, 30);
        include(loginControls, 120, 100);
        include(customerAccessButton, 150, 230, 200, 30);

    }

    /**
     * @return username field.
     */
    public TextField getUsernameField() {

        return usernameField;

    }

    /**
     * @return password field.
     */
    public PasswordField getPasswordField() {

        return passwordField;

    }

    @Override
    public Scene getScene() {

        return scene;

    }

    @Override
    public void registerBTNActions(Controller controller) {

        adminLoginButton.setOnAction(controller);
        customerAccessButton.setOnAction(controller);

    }

}