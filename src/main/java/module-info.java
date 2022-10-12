module com.mmacedo.calculator.multipurposecalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mmacedo.calculator.multipurposecalculator to javafx.fxml;
    exports com.mmacedo.calculator.multipurposecalculator;
}