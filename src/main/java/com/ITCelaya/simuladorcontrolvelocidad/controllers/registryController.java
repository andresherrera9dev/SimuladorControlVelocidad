package com.ITCelaya.simuladorcontrolvelocidad.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class registryController implements Initializable {
    @FXML
    private TableView<?> tableViewRegistry;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewRegistry.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableViewRegistry.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            double totalWidth = newWidth.doubleValue();
            int columnCount = tableViewRegistry.getColumns().size();

            if (columnCount > 0) {
                double adjustedWidth = totalWidth - 20;
                double columnWidth = adjustedWidth / columnCount;
                for (TableColumn<?, ?> column : tableViewRegistry.getColumns()) {
                    column.setPrefWidth(columnWidth);
                }
            }
        });
    }
}
