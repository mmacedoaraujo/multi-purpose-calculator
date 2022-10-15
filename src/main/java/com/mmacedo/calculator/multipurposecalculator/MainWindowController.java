package com.mmacedo.calculator.multipurposecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    @FXML
    private BorderPane borderPane;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField textField;
    @FXML
    private Button standardCalculatorButton;
    @FXML
    private Button bmiCalculatorButton;
    @FXML
    private Button btnEqual;
    @FXML
    private Button btnClear;
    @FXML
    private ImageView eraseAllImgView;
    @FXML
    private ImageView btnMinimize;
    @FXML
    private ImageView btnClose;
    private String numbers = "";
    private String operator = "";
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
    void eraseAll(MouseEvent event) {
        textField.deleteText(0, numbers.length());
        numbers = textField.getText();
        operator = textField.getText();


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
        textField.clear();
        numbers = "";
    }

    @FXML
    void onNumberClicked(MouseEvent event) {
        numbers += ((Button) event.getSource()).getText();
        if (!operator.isEmpty()) {
            textField.setText(numbers + operator);
        } else {
            textField.setText(numbers);
        }


    }

    @FXML
    void onOperatorClicked(MouseEvent event) {
        operator = ((Button) event.getSource()).getText();
        textField.setText(numbers + operator);
    }

    public String eraseChar(String s) {
        return s.replaceAll(".$", "");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}