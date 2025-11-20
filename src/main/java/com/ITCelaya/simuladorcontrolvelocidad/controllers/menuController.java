package com.ITCelaya.simuladorcontrolvelocidad.controllers;

import com.ITCelaya.simuladorcontrolvelocidad.util.*;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import static com.ITCelaya.simuladorcontrolvelocidad.util.CarMovement.simulateCarMovement;

public class menuController {
    @FXML
    private ImageView imageCar;
    @FXML
    private Label plateLbl, pointsLbl, velocityLbl;
    @FXML
    private VBox windowContainer;
    @FXML
    private Button simulationBtn;

    private Timeline simulationLoop;
    private boolean simulationWindowCheck = true;

    @FXML
    void loadSimulation() {
        if (simulationLoop != null) stopSimulation();
        else if (simulationWindowCheck) {
            generateValues();
            buttonStyle("Detener simulacion", "#bd6363");
            startSimulationLoop();
        } else {
            SceneManager.loadVbox(windowContainer, "fxml/simulation-view.fxml", this);
            buttonStyle("Iniciar simulacion", "#63bd6a");
            simulationWindowCheck = true;
        }
    }

    @FXML
    void loadRegistry() {
        if (simulationLoop != null) stopSimulation();
        buttonStyle("Mostrar simulador", "#63bd6a");
        SceneManager.loadVbox(windowContainer, "fxml/registry-view.fxml", null);
        simulationWindowCheck = false;
    }

    @FXML
    void exitProgram() {
        SceneManager.launchNewWindow("fxml/exit-view.fxml");
    }

    private void startSimulationLoop() {
        simulationLoop = new Timeline(
                new KeyFrame(Duration.seconds(2), e -> {
                    if (!simulationWindowCheck) {
                        simulationLoop.stop();
                        return;
                    }
                    generateValues();
                })
        );
        simulationLoop.setCycleCount(Timeline.INDEFINITE);
        simulationLoop.play();
    }


    void stopSimulation() {
            simulationLoop.stop();
            CarMovement.initCarMovement(imageCar);
            simulationLoop = null;
            labelsSetEmptyText();
    }
    private static MiddleSquareGenerator generator = new MiddleSquareGenerator(8247);

    void generateValues() {
        int speed = RandomSpeed.getRandomSpeed();
        String plate = RandomPlate.generatePlate(generator.nextInt(1000)<500);
        velocityLbl.setText(speed + " Km/h");
        plateLbl.setText(plate);
        if (speed <= 60 && RandomPlate.isGuanajuatoPlate(plate)){
            pointsLbl.setText("+100");
        }
        else
        {
            pointsLbl.setText("0");
        }
        simulateCarMovement(1, 1, imageCar);
    }
    void labelsSetEmptyText() {
        simulationBtn.setStyle("-fx-background-color: #63bd6a");
        simulationBtn.setText("Iniciar simulacion");
        pointsLbl.setText("");
        plateLbl.setText("");
        velocityLbl.setText("");
    }

    void buttonStyle(String text, String Style){
        simulationBtn.setText(text);
        simulationBtn.setStyle("-fx-background-color: "+Style);
    }
}