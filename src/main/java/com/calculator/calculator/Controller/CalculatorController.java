package com.calculator.calculator.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField result;

    @FXML
    private Button btnAddition;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDivision;

    @FXML
    private Button btnEight;

    @FXML
    private Button btnEqual;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnMultiplication;

    @FXML
    private Button btnNine;

    @FXML
    private Button btnOne;

    @FXML
    private Button btnPercentage;

    @FXML
    private Button btnPoint;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnSix;

    @FXML
    private Button btnSubtraction;

    @FXML
    private Button btnThree;

    @FXML
    private Button btnTwo;

    @FXML
    private Button btnZero;

    @FXML
    void clickClear(ActionEvent event) {

    }

    @FXML
    void clickEqual(ActionEvent event) {

    }

    @FXML
    void clickNumberButton(ActionEvent event) {
        String number = getButtonValue(event);
        String textResult = result.getText();
        if(".".equals(number)){
            boolean contains = textResult.contains(".");
            if(contains||isBlank(textResult)){
                return;
            }else {
                result.setText(textResult+".");
                return;
            }
        }
        result.setText(result.getText()+number);
    }

    private String getButtonValue(ActionEvent event){
        Button button = (Button)event.getSource();
        return button.getText();
    }


    private boolean isBlank(String text){
        if(text!=null&&text!=""&&text.length()>0)
            return false;
        return true;
    }





    @FXML
    void clickOperationButton(ActionEvent event) {

    }

}
