package com.ITCelaya.simuladorcontrolvelocidad;

import com.ITCelaya.simuladorcontrolvelocidad.util.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Simulador control de velocidades
 */
public class SimuladorCVApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneManager.setPrimaryStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(SimuladorCVApplication.class.getResource("fxml/menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(SimuladorCVApplication.class.getResource("css/stylesheet.css").toString());
    }
}