package com.ITCelaya.simuladorcontrolvelocidad.util;

import com.ITCelaya.simuladorcontrolvelocidad.SimuladorCVApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SceneManager {
    private static Stage primaryStage;
    private static Stage popupStage;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static void launchNewWindow(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(SimuladorCVApplication.class.getResource(fxmlFile));
            Pane root = loader.load();
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            popupStage = new Stage();
            popupStage.initStyle(StageStyle.TRANSPARENT);
            popupStage.setScene(scene);
            popupStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeProgram(){
        primaryStage.close();
    }
    public static void closePopup(){
        popupStage.close();
    }
}