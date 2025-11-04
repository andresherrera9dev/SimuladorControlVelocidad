package com.ITCelaya.simuladorcontrolvelocidad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Simulador control de velocidades
 */
public class SimuladorCVApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SimuladorCVApplication.class.getResource("fxml/simulator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Simulador Control De Velocidad");
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(SimuladorCVApplication.class.getResource("css/stylesheet.css").toString());
    }

    public static void main(String[] args) {
        launch();
    }
}