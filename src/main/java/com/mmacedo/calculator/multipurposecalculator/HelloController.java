package com.mmacedo.calculator.multipurposecalculator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Label welcomeText;

    @FXML
    private Button imcButton;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        AnchorPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BMICalculator.fxml")));
        borderPane.setCenter(view);
    }
}