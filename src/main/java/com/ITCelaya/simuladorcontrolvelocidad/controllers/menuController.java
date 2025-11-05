package com.ITCelaya.simuladorcontrolvelocidad.controllers;

import com.ITCelaya.simuladorcontrolvelocidad.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class menuController {
    @FXML
    private VBox mainContainer;

    @FXML
    void loadSimulation() {

    }
    @FXML
    void loadRegistry() {

    }
    @FXML
    void exitProgram() {
        SceneManager.launchNewWindow("fxml/exit-view.fxml");
    }
}
