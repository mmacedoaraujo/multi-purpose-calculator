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
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainWindowController {
    @FXML
    private BorderPane borderPane;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label lblResult;
    @FXML
    private Label lblSaved;
    @FXML
    private Button standardCalculatorButton;

    @FXML
    private Button bmiCalculatorButton;
    @FXML
    private Button btnEqual;
    @FXML
    private Button btnClear;

    @FXML
    private ImageView btnMinimize;

    @FXML
    private ImageView btnClose;
    private String firstNumber = "";
    private String currentNumber = "";
    private String savedNumber = "";
    private String operationsHistory = "";
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
        savedNumber = "";
        currentNumber = "";
        lblResult.setText("");
        lblSaved.setText("");
    }

    @FXML
    void onNumberClicked(MouseEvent event) {
        firstNumber = ((Button) event.getSource()).getText();
        addNumber(firstNumber);
    }

    @FXML
    void onSymbolClicked(MouseEvent event) {
        String newNumber = String.format("%s%s", currentNumber, ((Button) event.getSource()).getText());
        Pattern pattern = Pattern.compile("[\\d]");
        Matcher matcher = pattern.matcher(newNumber);
        Boolean matchFound = matcher.find();

        if (matchFound) {
            savedNumber += newNumber;
            currentNumber = "";
            lblResult.setText("");
            lblSaved.setText(savedNumber.replaceAll("^0+", ""));
        }

    }

    @FXML
    void onEqualClicked(MouseEvent event) {
        lblSaved.setText(savedNumber.substring(0, savedNumber.length()) + currentNumber + "=");
        Integer savedNumberConverted = Integer.parseInt(savedNumber.replaceAll("\\D$", ""));
        Integer currentNumberConverted = Integer.parseInt(currentNumber.replaceAll("\\D$", ""));

        Integer result = adaptativeEqualBtnOperator("[\\+\\-\\/\\*]", savedNumber, savedNumberConverted, currentNumberConverted);
        updateDataMethod(result);

    }

    public void updateLabelResult() {
        lblResult.setText(currentNumber);
    }

    public void addNumber(String number) {
        currentNumber += number;
        updateLabelResult();
    }

    public Integer adaptativeEqualBtnOperator(String pattern, String matcher, Integer a, Integer b) {
        Matcher m = Pattern.compile(pattern).matcher(matcher);
        Integer result = 0;
        if (m.find()) {
            switch (m.group().charAt(0)) {
                case '+':

                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    result = a / b;
                    break;
            }

        }
        return result;
    }

    public void updateDataMethod(Integer result) {
        lblResult.setText(String.format("%d", result));
        currentNumber = String.valueOf(result);
        savedNumber = "";
        lblSaved.setText("");
    }

}