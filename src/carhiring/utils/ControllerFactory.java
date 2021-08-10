package carhiring.utils;

import carhiring.controllers.AdminController;
import carhiring.controllers.LoginController;
import carhiring.models.AdminModel;
import carhiring.models.LoginModel;
import carhiring.views.AdminView;
import carhiring.views.LoginView;

/**
 * ControllerFactory.java
 *
 * @version 1.0
 *
 * It is used to create different controllers
 * and initialise them.
 */
public class ControllerFactory {

    /**
     * Create a login controller and return it
     * for use.
     *
     * @param updater scene updater
     * @return login controller
     */
    public static LoginController createLoginController(SceneUpdater updater) {

        LoginView view = new LoginView();
        LoginModel model = new LoginModel();
        LoginController controller = new LoginController(updater, model, view);
        view.setController(controller);
        return controller;

    }

    /**
     * Create a admin controller and return it
     * for use.
     *
     * @param updater scene updater
     * @return admin controller
     */
    public static AdminController createAdminController(SceneUpdater updater) {

        AdminView view = new AdminView();
        AdminModel model = new AdminModel();
        AdminController controller = new AdminController(updater, model, view);
        view.setController(controller);
        return controller;

    }

}
