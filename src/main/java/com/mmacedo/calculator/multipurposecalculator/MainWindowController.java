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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainWindowController {
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
    private Button btnComma;
    @FXML
    private ImageView eraseAllImgView;
    @FXML
    private ImageView btnMinimize;
    @FXML
    private ImageView btnClose;
    private String rightSideNumbers = "";
    private String leftSideNumbers = "";
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
    protected void onStandardCalculatorButtonButtonClick() throws IOException {
        borderPane.setCenter(rootPane);
    }

    @FXML
    protected void onBmiCalculatorButtonButtonClick() throws IOException {
        AnchorPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BMICalculator.fxml")));
        borderPane.setCenter(view);
    }

    @FXML
    void eraseAll(MouseEvent event) {
        clearAllFields();
    }

    @FXML
    void onNumberClicked(MouseEvent event) {
        if (regexMatcher("(([\\d]{1,}|[\\d]+.[\\d]+)[\\s]{1}[\\+\\-\\/\\*]{1})", textField.getText())) {
            leftSideNumbers += ((Button) event.getSource()).getText();
            textField.setText(rightSideNumbers + " " + operator + " " + leftSideNumbers);

        }
        if (!regexMatcher("[\\+\\-\\/\\*]{1}|[\\.]{2}", textField.getText())) {
            rightSideNumbers += ((Button) event.getSource()).getText();
            textField.setText(rightSideNumbers + " " + operator);
        }

        if (regexMatcher("^[\\.]+", textField.getText())) {
            textField.deleteText(0, textField.getLength());
            rightSideNumbers = "";
            leftSideNumbers = "";
            operator = "";
        }

    }

    @FXML
    void onOperatorClicked(MouseEvent event) {
        if (regexMatcher("[\\d]", textField.getText())) {
            operator = ((Button) event.getSource()).getText();
            textField.setText(rightSideNumbers + " " + operator + " " + leftSideNumbers);
        }
    }

    public String eraseChar(String s) {
        return s.replaceAll(".$", "");
    }

    public Boolean regexMatcher(String pattern, String matcher) {
        Matcher m = Pattern.compile(pattern).matcher(matcher);
        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }

    public void clearAllFields() {
        textField.deleteText(0, textField.getLength());
        rightSideNumbers = "";
        leftSideNumbers = "";
        operator = "";
    }
}