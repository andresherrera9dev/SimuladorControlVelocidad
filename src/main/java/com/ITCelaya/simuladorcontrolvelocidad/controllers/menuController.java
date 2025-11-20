package com.ITCelaya.simuladorcontrolvelocidad.controllers;

import com.ITCelaya.simuladorcontrolvelocidad.util.CarMovement;
import com.ITCelaya.simuladorcontrolvelocidad.util.RandomPlate;
import com.ITCelaya.simuladorcontrolvelocidad.util.RandomSpeed;
import com.ITCelaya.simuladorcontrolvelocidad.util.SceneManager;

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
    private boolean simulationWindow = true;

    @FXML
    void loadSimulation() {
        if (stopSimulation()) ;
        else if (simulationWindow) {
            plateLbl.setText(RandomPlate.generatePlate());
            int speed = RandomSpeed.getRandomSpeed();
            if (speed <= 60)
                pointsLbl.setText("+100");
            else
                pointsLbl.setText("0");
            velocityLbl.setText(Integer.toString(speed));
            simulateCarMovement(1, 1, imageCar);
            buttonStyle("Detener simulacion", "#bd6363");
            startSimulationLoop();
        } else {
            SceneManager.loadVbox(windowContainer, "fxml/simulation-view.fxml", this);
            simulationWindow = true;
        }
    }

    @FXML
    void loadRegistry() {
        stopSimulation();
        buttonStyle("Iniciar simulacion", "#63bd6a");
        SceneManager.loadVbox(windowContainer, "fxml/registry-view.fxml", null);
        simulationWindow = false;
    }

    @FXML
    void exitProgram() {
        SceneManager.launchNewWindow("fxml/exit-view.fxml");
    }

    private void startSimulationLoop() {
        simulationLoop = new Timeline(
                new KeyFrame(Duration.seconds(2), e -> {
                    if (!simulationWindow) {
                        simulationLoop.stop();
                        return;
                    }
                    String plate = RandomPlate.generatePlate();
                    int speed = RandomSpeed.getRandomSpeed();
                    labelsSetText(plate, speed);
                    simulateCarMovement(1, 1, imageCar);
                })
        );
        simulationLoop.setCycleCount(Timeline.INDEFINITE);
        simulationLoop.play();
    }

    boolean stopSimulation() {
        if (simulationLoop != null) {
            simulationLoop.stop();
            CarMovement.initCarMovement(imageCar);
            simulationLoop = null;
            labelsSetText();
            return true;
        }
        else
            return false;
    }
    void labelsSetText(String plate, int speed) {
        velocityLbl.setText(speed + " Km/h");
        plateLbl.setText(plate);
        if (speed <= 60){
            pointsLbl.setText("+100");
        }
        else
        {
            pointsLbl.setText("0");
        }
    }
    void labelsSetText() {
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