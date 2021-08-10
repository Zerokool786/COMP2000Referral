package carhiring.views;

import carhiring.controllers.Controller;
import carhiring.controllers.CustomerController;
import carhiring.models.data.Car;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.time.LocalDate;

/**
 * CustomerView.java
 *
 * @version 1.0
 *
 * It represents the view for the
 * customer controller.
 */
public class CustomerView extends View {

    // Attributes..
    private Scene scene;
    private Button logoutButton;
    private Button bookCarButton;
    private TextField nameField;
    private TextField addressField;
    private TextField licenseField;
    private DatePicker returnDatePicker;
    private TableView<Car> availableCarsTable;
    private Label totalCostLabel;

    @Override
    public void initUI() {

        scene = new Scene(getGroup(), 900, 500);

        // init..
        logoutButton = new Button("Logout");
        bookCarButton = new Button("Book Car");

        // setting colors.
        bookCarButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        logoutButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");

        // Setting ids.
        bookCarButton.setId("BOOK_CAR");
        logoutButton.setId("LOGOUT_CUSTOMER");

        // Table for available cars
        availableCarsTable = new TableView<>();

        // Table columns for available cars table.
        TableColumn<Car, String> availableCarColumn1 = new TableColumn<>("Name");
        availableCarColumn1.setCellValueFactory(new PropertyValueFactory<>("name"));
        availableCarColumn1.prefWidthProperty().bind(availableCarsTable.widthProperty().multiply(0.492));
        TableColumn<Car, Double> availableCarColumn2 = new TableColumn<>("Cost Per Day");
        availableCarColumn2.setCellValueFactory(new PropertyValueFactory<>("costPerDay"));
        availableCarColumn2.prefWidthProperty().bind(availableCarsTable.widthProperty().multiply(0.492));

        availableCarsTable.getColumns().addAll(availableCarColumn1,
                availableCarColumn2);

        returnDatePicker = new DatePicker(LocalDate.now());
        totalCostLabel = font(new Label("Total Cost: $0"), 17);

        // Box for booking car.
        HBox bookBox = new HBox();
        bookBox.setSpacing(10);
        bookBox.setAlignment(Pos.CENTER);

        bookBox.getChildren().addAll(new Label("Select Return Date: "), returnDatePicker, totalCostLabel);

        nameField = new TextField();
        addressField = new TextField();
        licenseField = new TextField();

        // Box for booking car.
        HBox detailsBox = new HBox();
        detailsBox.setSpacing(10);
        detailsBox.setAlignment(Pos.CENTER);

        detailsBox.getChildren().addAll(new Label("Enter Name: "), nameField,
                new Label("Enter Address: "), addressField,
                new Label("Enter License: "), licenseField);

        // including the components into the panel
        include(font(new Label("Customer Control System"), 16), 330, 10);
        include(logoutButton, 800, 10, 80, 25);
        include(font(new Label("Select Car for Booking"), 12), 20, 40);
        include(availableCarsTable, 20, 70, 860, 270);
        include(bookBox, 20, 360);
        include(detailsBox, 20, 400);
        include(bookCarButton, 20, 440, 150, 40);

    }

    /**
     * Setting the new cost.
     *
     * @param cost updated cost.
     */
    public void setTotalCost(double cost) {

        totalCostLabel.setText("Total Cost: $"+String.format("%.2f", cost));

    }

    @Override
    public Scene getScene() {

        return scene;

    }

    @Override
    public void registerBTNActions(Controller controller) {

        this.bookCarButton.setOnAction(controller);
        this.logoutButton.setOnAction(controller);
        this.returnDatePicker.valueProperty().addListener((CustomerController) controller);

    }

    /**
     * @return available cars table
     */
    public TableView<Car> getAvailableCarsTable() {

        return availableCarsTable;

    }

    /**
     * @return name field
     */
    public TextField getNameField() {

        return nameField;

    }

    /**
     * @return address field
     */
    public TextField getAddressField() {

        return addressField;

    }

    /**
     * @return license field
     */
    public TextField getLicenseField() {

        return licenseField;

    }
}
