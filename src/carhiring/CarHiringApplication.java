package carhiring;

import carhiring.controllers.Controller;
import carhiring.utils.ControllerFactory;
import carhiring.utils.SceneType;
import carhiring.utils.SceneUpdater;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * CarHiringController
 *
 * @version 1.0
 * <p>
 * It is the Main Controller and only
 * one Application class which has the
 * responsibility to handle all stages and
 * scenes of the program.
 */
public class CarHiringApplication extends Application implements SceneUpdater {

    // Attributes..
    private Stage stage;
    private Controller currentController;
    private ReceiptStage receiptStage;

    /**
     * To initialise the stage and
     * scenes including its components.
     *
     * @param primaryStage main stage of application.
     */
    @Override
    public void start(Stage primaryStage) {

        this.stage = primaryStage;

        // Initialising the stage.
        primaryStage.setTitle("Car Hiring Program");

        // setting the login controller
        updateControllerSceneType(SceneType.LOGIN);

        // Start the program.
        primaryStage.show();

        // setting up the receipt stage.
        //receiptStage = new ReceiptStage();

    }

    @Override
    public void updateScene(Scene scene) {

        this.stage.setScene(scene);

    }

    @Override
    public void updateController(Controller controller) {

        this.currentController = controller;
        updateScene(controller.getView().getScene());

    }

    @Override
    public void updateControllerSceneType(SceneType type) {

        Controller controller = null;
        switch (type) {

            case LOGIN:
                controller = ControllerFactory.createLoginController(this);
                break;
            case MAIN_CUSTOMER:
                controller = ControllerFactory.createCustomerController(this);
                break;
            case MAIN_ADMIN:
                controller = ControllerFactory.createAdminController(this);
                break;

        }
        if (controller != null) {
            updateController(controller);
        }

    }

}