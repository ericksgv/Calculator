package com.calculator.calculator.Controller;

import com.calculator.calculator.Model.CalculatorModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;


public class CalculatorController {

    @FXML
    private TextField screen;

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

    CalculatorModel calculatorModel;

    void initialize(){
        calculatorModel = new CalculatorModel();
    }

    @FXML
    void clickClear(ActionEvent event) {
        if (screen.getText().isEmpty())
            return;
        screen.setText("");
    }

    @FXML
    void clickNumberButton(ActionEvent event) {
        Button button = (Button)event.getSource();
        String number = button.getText();
        String textScreen = screen.getText();
        char lastChar = '.';
        if(!textScreen.isEmpty())
            lastChar = textScreen.charAt(textScreen.length() - 1);

        if(".".equals(number)){
            boolean contains = textScreen.contains(".");
            if(screen.getText().isEmpty() || lastChar == '%' || lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '÷' || lastChar == '.'){
                return;
            }else {
                screen.setText(textScreen+".");
                return;
            }
        }
        screen.setText(screen.getText()+number);
    }

    @FXML
    void clickOperationButton(ActionEvent event) {
        Button button = (Button)event.getSource();
        String operation = button.getText();
        String textScreen = screen.getText();
        char lastChar = '.';
        if(!textScreen.isEmpty())
            lastChar = textScreen.charAt(textScreen.length() - 1);

        if(screen.getText().isEmpty())
            return;
        else if (lastChar == '.' || lastChar == '%' || lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '÷')
            return;

        screen.setText(textScreen+operation);

        //screen.setText(screen.getText()+operation);
    }

    @FXML
    void clickEqual(ActionEvent event) {
        String textScreen = screen.getText();
        char lastChar = '.';
        String[]numRead = textScreen.split("%|\\+|\\-|\\*|\\÷");
        Float[]numbers = null;
        ArrayList<Character> operations = new ArrayList<>();

        if(!textScreen.isEmpty())
            lastChar = textScreen.charAt(textScreen.length() - 1);
        else
            return;
        if (lastChar == '.' || lastChar == '%' || lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '÷')
            return;
        if(numRead != null){
            numbers = new Float[numRead.length];
            for (int i = 0; i < numRead.length; i++) {
                numbers[i] = Float.parseFloat(numRead[i]);
            }
            int counter = 0;
            for (int i = 0; i < textScreen.length(); i++)
                if (textScreen.charAt(i) == '%' || textScreen.charAt(i) == '+' || textScreen.charAt(i) == '-' || textScreen.charAt(i) == '*' || textScreen.charAt(i) == '÷') {
                    operations.add(textScreen.charAt(i));
                    System.out.println("OpGuardada: " + operations.get(counter));
                    counter++;
                }
            for(int i = 0; i < operations.size(); i++){
                switch(operations.get(i)){
                    case '+':
                        screen.setText(String.valueOf(numbers[0] + numbers[1]));
                        break;

                    case '-':
                        screen.setText(String.valueOf(numbers[0] - numbers[1]));
                        break;

                    case '%':
                        screen.setText(String.valueOf(numbers[0] % numbers[1]));
                        break;

                    case '÷':
                        screen.setText(String.valueOf(numbers[0] / numbers[1]));
                        break;

                    case '*':
                        screen.setText(String.valueOf(numbers[0] * numbers[1]));
                        break;
                }
            }
        }



    }

}
