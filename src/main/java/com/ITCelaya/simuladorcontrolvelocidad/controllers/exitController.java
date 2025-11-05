package com.ITCelaya.simuladorcontrolvelocidad.controllers;

import com.ITCelaya.simuladorcontrolvelocidad.util.SceneManager;
import javafx.fxml.FXML;

public class exitController {
    @FXML
    void closePrimaryStage() {
        SceneManager.closeProgram();
        SceneManager.closePopup();
    }

    @FXML
    void closeThisStage() {
        SceneManager.closePopup();
    }
}