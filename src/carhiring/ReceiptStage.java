package carhiring;

import carhiring.models.data.Booking;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ReceiptStage extends Stage {

    private Group group;
    private Label todayDate;
    private Label carName;
    private Label costPerDay;
    private Label customerName;
    private Label customerAddress;
    private Label customerLicense;
    private Label totalDays;
    private Label returnDate;
    private Label totalCost;

    /**
     * Default Constructor.
     */
    public ReceiptStage() {

        group = new Group();
        Scene scene = new Scene(group, 300, 550);

        this.setTitle("Receipt Printer");
        this.setScene(scene);

        // init the components..
        todayDate = new Label(String.valueOf(LocalDate.now()));
        carName = new Label();
        costPerDay = new Label();
        customerName = new Label();
        customerAddress = new Label();
        customerLicense = new Label();
        totalDays = new Label();
        returnDate = new Label();
        totalCost = new Label();

        // Creating a box.
        VBox box = new VBox();
        box.setSpacing(7);
        box.setAlignment(Pos.CENTER_LEFT);

        box.getChildren().addAll(
                font(new Label("Today Date"), 14), todayDate,
                font(new Label("Company Name"), 14), new Label("Car Hiring Company LTD"),
                font(new Label("Car Name"), 14), carName,
                font(new Label("Cost Per Day"), 14), costPerDay,
                font(new Label("Customer Name"), 14), customerName,
                font(new Label("Customer Address"), 14), customerAddress,
                font(new Label("Customer License"), 14), customerLicense,
                font(new Label("Total Days"), 14), totalDays,
                font(new Label("Returned Date"), 14), returnDate,
                font(new Label("Total Cost"), 14), totalCost);

        // Adding the components..
        include(font(new Label("Generated Receipt"), 16), 70, 10);
        include(box, 20, 50);

    }

    /**
     * Setting the new booking.
     *
     * @param booking to do booking
     */
    public void setBooking(Booking booking) {

        carName.setText(booking.getCar().getName());
        costPerDay.setText("$"+booking.getCar().getCostPerDay());
        customerName.setText(booking.getCustomer().getName());
        customerAddress.setText(booking.getCustomer().getAddress());
        customerLicense.setText(booking.getCustomer().getDrivingLicenseNumber());
        totalDays.setText(booking.getTotalDays() + "");
        returnDate.setText(String.valueOf(booking.getReturnDate()));
        totalCost.setText("$"+booking.getTotalCost());

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

}
