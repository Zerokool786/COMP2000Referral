package carhiring.controllers;

import carhiring.models.AdminModel;
import carhiring.models.Model;
import carhiring.models.data.Car;
import carhiring.utils.SceneType;
import carhiring.utils.SceneUpdater;
import carhiring.views.AdminView;
import carhiring.views.View;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * AdminController.java
 *
 * @version 1.0
 *
 * It is used to handle both view and
 * model of the admin panel.
 */
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

        // Populating the data.
        getAdminView().getAvailableCarsTable().getItems().addAll(getAdminModel().getAvailableCars());
        getAdminView().getBookedCarsTable().getItems().addAll(getAdminModel().getBookingList());

    }

    /**
     * @return admin model
     */
    public AdminModel getAdminModel() {

        AdminModel model = (AdminModel) getModel();
        return model;

    }

    /**
     * @return admin view
     */
    public AdminView getAdminView() {

        AdminView view = (AdminView) getView();
        return view;

    }

    /**
     * To perform actions when any button is
     * clicked.
     *
     * @param actionEvent for button.
     */
    @Override
    public void handle(ActionEvent actionEvent) {

        Button button = (Button) actionEvent.getSource();
        switch (button.getId()) {
            case "CREATE_CAR":

                String name = getAdminView().getCarNameField().getText();
                String price = getAdminView().getCarPriceField().getText();

                if (name.isEmpty()) {
                    getView().createAlert(Alert.AlertType.ERROR, "Name should not be empty.");
                    return;
                }

                try {

                    double priceNum = Double.parseDouble(price);
                    getAdminModel().addCar(new Car(name, priceNum));
                    getAdminView().getAvailableCarsTable().getItems().clear();
                    getAdminView().getAvailableCarsTable().getItems().addAll(getAdminModel().getAvailableCars());
                    getView().createAlert(Alert.AlertType.INFORMATION, "New Car is added successfully!");

                } catch (Exception e) {
                    getView().createAlert(Alert.AlertType.ERROR, "Price should be valid.");
                    return;
                }

                break;
            case "UPDATE_CAR":

                int index = getAdminView().getAvailableCarsTable().getSelectionModel().getSelectedIndex();
                Car selectedCar = getAdminView().getAvailableCarsTable().getSelectionModel().getSelectedItem();
                if (selectedCar == null) {
                    getView().createAlert(Alert.AlertType.ERROR, "Select only 1 car in the car available table.");
                } else {

                    price = getAdminView().getUpdateCarPriceField().getText();

                    try {

                        double priceNum = Double.parseDouble(price);
                        selectedCar.setCostPerDay(priceNum);
                        getAdminModel().updateCar(index, selectedCar);
                        getAdminView().getAvailableCarsTable().getItems().clear();
                        getAdminView().getAvailableCarsTable().getItems().addAll(getAdminModel().getAvailableCars());
                        getView().createAlert(Alert.AlertType.INFORMATION, "Car details are updated successfully!");

                    } catch (Exception e) {
                        getView().createAlert(Alert.AlertType.ERROR, "Price should be valid.");
                        return;
                    }

                }

                break;
            case "RETURN_CAR":

                index = getAdminView().getBookedCarsTable().getSelectionModel().getSelectedIndex();
                if (index != -1) {
                    getAdminModel().returnBooking(index);
                    getAdminView().getAvailableCarsTable().getItems().clear();
                    getAdminView().getAvailableCarsTable().getItems().addAll(getAdminModel().getAvailableCars());
                    getAdminView().getBookedCarsTable().getItems().clear();
                    getAdminView().getBookedCarsTable().getItems().addAll(getAdminModel().getBookingList());
                    getView().createAlert(Alert.AlertType.INFORMATION, "Car returned successfully!");
                } else {
                    getView().createAlert(Alert.AlertType.ERROR, "Select booking to return it.");
                }

                break;
            case "LOGOUT_ADMIN":
                getUpdater().updateControllerSceneType(SceneType.LOGIN);
                break;
        }

    }

}
