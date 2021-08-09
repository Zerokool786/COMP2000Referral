package carhiring.utils;

import carhiring.controllers.Controller;
import javafx.scene.Scene;

/**
 * SceneUpdater.java
 *
 * @version 1.0
 *
 * It will be used to update the scene
 * in the main application.
 *
 * It is a part of Observer pattern.
 */
public interface SceneUpdater {

    /**
     * It will update the passed scene.
     *
     * @param scene new scene to setup.
     */
    void updateScene(Scene scene);

    /**
     * It will replace the previous controller
     * and update the scene accordingly.
     *
     * @param controller new controller to set.
     */
    void updateController(Controller controller);

    /**
     * It will update the controller and
     * scene according to the scene type.
     *
     * @param type type of scene.
     */
    void updateControllerSceneType(SceneType type);

}
