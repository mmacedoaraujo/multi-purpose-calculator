package com.mmacedo.calculator.multipurposecalculator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class SceneController {
    @FXML
    private BorderPane borderPane;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label welcomeText;

    @FXML
    private Button standardCalculatorButton;

    @FXML
    private Button bmiCalculatorButton;

    @FXML
    protected void onStandardCalculatorButtonButtonClick() throws IOException {
        borderPane.setCenter(rootPane);
    }

    @FXML
    protected void onBmiCalculatorButtonButtonClick() throws IOException {
        AnchorPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BMICalculator.fxml")));
        borderPane.setCenter(view);
    }

}