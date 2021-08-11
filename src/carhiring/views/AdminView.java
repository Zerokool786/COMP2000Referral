package carhiring.views;

import carhiring.controllers.Controller;
import carhiring.models.data.Booking;
import carhiring.models.data.Car;
import carhiring.models.data.Customer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.time.LocalDate;

/**
 * AdminView.java
 *
 * @version 1.0
 *
 * It is used to create a view and
 * represents the components for Admin panel.
 */
public class AdminView extends View {

    // Attributes..
    private Scene scene;
    private TextField carNameField;
    private TextField carPriceField;
    private TextField updateCarPriceField;
    private Button createCarButton;
    private Button updateCarButton;
    private Button returnCarButton;
    private Button logoutButton;
    private TableView<Car> availableCarsTable;
    private TableView<Booking> bookedCarsTable;

    @Override
    public void initUI() {

        scene = new Scene(getGroup(), 900, 500);

        // init..
        carNameField = new TextField();
        carPriceField = new TextField();
        updateCarPriceField = new TextField();
        createCarButton = new Button("Create Car");
        updateCarButton = new Button("Update Cost");
        logoutButton = new Button("Logout");
        returnCarButton = new Button("Car Returned");

        // setting colors.
        createCarButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        updateCarButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        logoutButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        returnCarButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");

        // Setting ids.
        createCarButton.setId("CREATE_CAR");
        updateCarButton.setId("UPDATE_CAR");
        returnCarButton.setId("RETURN_CAR");
        logoutButton.setId("LOGOUT_ADMIN");

        // Box for creating car.
        HBox createBox = new HBox();
        createBox.setSpacing(10);
        createBox.setAlignment(Pos.CENTER);

        createBox.getChildren().addAll(new Label("Enter Car Name: "), carNameField,
                new Label("Enter Cost Per Day: "), carPriceField, createCarButton);

        // Table for available cars
        availableCarsTable = new TableView<>();

        // Table columns for available cars table.
        TableColumn<Car, String> availableCarColumn1 = new TableColumn<>("Name");
        availableCarColumn1.setCellValueFactory(new PropertyValueFactory<>("name"));
        availableCarColumn1.prefWidthProperty().bind(availableCarsTable.widthProperty().multiply(0.32));
        TableColumn<Car, Double> availableCarColumn2 = new TableColumn<>("Cost Per Day");
        availableCarColumn2.setCellValueFactory(new PropertyValueFactory<>("costPerDay"));
        availableCarColumn2.prefWidthProperty().bind(availableCarsTable.widthProperty().multiply(0.32));
        TableColumn<Car, String> availableCarColumn3 = new TableColumn<>("Available");
        availableCarColumn3.setCellValueFactory(new PropertyValueFactory<>("availableStatus"));
        availableCarColumn3.prefWidthProperty().bind(availableCarsTable.widthProperty().multiply(0.32));

        availableCarsTable.getColumns().addAll(availableCarColumn1,
                availableCarColumn2, availableCarColumn3);

        // Update panel.
        HBox updateBox = new HBox();
        updateBox.setSpacing(10);
        updateBox.setAlignment(Pos.CENTER);

        updateBox.getChildren().addAll(new Label("Enter Updated Cost Per Day: "),
                updateCarPriceField, updateCarButton);

        // Table for booked cars
        bookedCarsTable = new TableView<>();

        // Table columns for available cars table.
        TableColumn<Booking, Customer> bookedCarColumn1 = new TableColumn<>("Customer Name");
        bookedCarColumn1.setCellValueFactory(new PropertyValueFactory<>("customer"));
        bookedCarColumn1.prefWidthProperty().bind(availableCarsTable.widthProperty().multiply(0.245));
        TableColumn<Booking, Customer> bookedCarColumn2 = new TableColumn<>("Car Name");
        bookedCarColumn2.setCellValueFactory(new PropertyValueFactory<>("car"));
        bookedCarColumn2.prefWidthProperty().bind(availableCarsTable.widthProperty().multiply(0.245));
        TableColumn<Booking, LocalDate> bookedCarColumn3 = new TableColumn<>("Return Date");
        bookedCarColumn3.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        bookedCarColumn3.prefWidthProperty().bind(availableCarsTable.widthProperty().multiply(0.245));
        TableColumn<Booking, Double> bookedCarColumn4 = new TableColumn<>("Total Cost");
        bookedCarColumn4.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        bookedCarColumn4.prefWidthProperty().bind(availableCarsTable.widthProperty().multiply(0.245));

        bookedCarsTable.getColumns().addAll(bookedCarColumn1, bookedCarColumn2,
                bookedCarColumn3, bookedCarColumn4);

        // including the components into the scene..
        include(font(new Label("Admin Control System"), 16), 350, 10);
        include(logoutButton, 800, 10, 80, 25);
        include(font(new Label("Create New Car"), 12), 20, 40);
        include(createBox, 20, 70);
        include(availableCarsTable, 20, 110, 860, 100);
        include(font(new Label("Update Car (Select Row from Table to Update)"), 12), 20, 230);
        include(updateBox, 20, 260);
        include(font(new Label("Booked Cars"), 12), 20, 300);
        include(bookedCarsTable, 20, 330, 860, 110);
        include(returnCarButton, 780, 450, 100, 30);

    }

    @Override
    public Scene getScene() {

        return scene;

    }

    @Override
    public void registerBTNActions(Controller controller) {

        createCarButton.setOnAction(controller);
        updateCarButton.setOnAction(controller);
        returnCarButton.setOnAction(controller);
        logoutButton.setOnAction(controller);

    }

    /**
     * @return car name field
     */
    public TextField getCarNameField() {

        return carNameField;

    }

    /**
     * @return car price field
     */
    public TextField getCarPriceField() {

        return carPriceField;

    }

    /**
     * @return updated car price field
     */
    public TextField getUpdateCarPriceField() {

        return updateCarPriceField;

    }

    /**
     * @return available cars table
     */
    public TableView<Car> getAvailableCarsTable() {

        return availableCarsTable;

    }

    /**
     * @return booking table
     */
    public TableView<Booking> getBookedCarsTable() {

        return bookedCarsTable;

    }

}
