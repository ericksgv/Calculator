module com.calculator.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.calculator.calculator to javafx.fxml;
    exports com.calculator.calculator;
    exports com.calculator.calculator.Controller;
    opens com.calculator.calculator.Controller to javafx.fxml;
}