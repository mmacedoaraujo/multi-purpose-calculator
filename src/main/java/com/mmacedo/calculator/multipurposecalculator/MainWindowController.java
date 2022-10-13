package com.mmacedo.calculator.multipurposecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainWindowController {
    @FXML
    private BorderPane borderPane;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label lblResult;
    @FXML
    private Button standardCalculatorButton;

    @FXML
    private Button bmiCalculatorButton;

    @FXML
    private Button btnClear;

    @FXML
    private ImageView btnMinimize;

    @FXML
    private ImageView btnClose;

    private String firstNumber = "";

    private String currentNumber = "";
    private double x, y;

    public void init(Stage stage) {
        borderPane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        borderPane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        btnClose.setOnMouseClicked(mouseEvent -> stage.close());
        btnMinimize.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }

    @FXML
    protected void onStandardCalculatorButtonButtonClick() throws IOException {
        borderPane.setCenter(rootPane);
    }

    @FXML
    protected void onBmiCalculatorButtonButtonClick() throws IOException {
        AnchorPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BMICalculator.fxml")));
        borderPane.setCenter(view);
    }

    @FXML
    void onBtnClearClicked(ActionEvent event) {
        currentNumber = "";
        lblResult.setText("");
    }

    @FXML
    void onNumberClicked(MouseEvent event) {
        firstNumber = ((Button) event.getSource()).getText();
        addNumber(firstNumber);
    }


    void onSymbolClicked(MouseEvent event) {
        addSymbol(((Button) event.getSource()).getText());
    }

    public void updateLabelResult() {
        lblResult.setText(currentNumber);
    }

    public void addNumber(String number) {
        currentNumber += number;
        updateLabelResult();
    }

    private void addSymbol(String text) {

    }

}