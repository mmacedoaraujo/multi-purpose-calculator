package com.mmacedo.calculator.multipurposecalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class CalculatorAPP extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("StandardCalculator.fxml"));
        Scene scene = new Scene(loader.load());
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Multi Purpose Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((MainWindowController)loader.getController()).init(stage);

    }

    public static void main(String[] args) {
        launch();
    }
}