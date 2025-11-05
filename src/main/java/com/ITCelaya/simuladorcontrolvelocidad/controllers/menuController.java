package com.ITCelaya.simuladorcontrolvelocidad.controllers;

import com.ITCelaya.simuladorcontrolvelocidad.util.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class menuController implements Initializable {
    @FXML
    private VBox windowContainer;

    @FXML
    void loadSimulation() {
        SceneManager.loadVbox(windowContainer, "fxml/simulation-view.fxml");

    }
    @FXML
    void loadRegistry() {
        SceneManager.loadVbox(windowContainer, "fxml/registry-view.fxml");

    }
    @FXML
    void exitProgram() {
        SceneManager.launchNewWindow("fxml/exit-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SceneManager.loadVbox(windowContainer, "fxml/welcome-view.fxml");
    }
}
