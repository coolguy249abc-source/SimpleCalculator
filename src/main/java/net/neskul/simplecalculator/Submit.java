package net.neskul.simplecalculator;

import net.neskul.simplecalculator.error.ErrorHandling;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

public class Submit {
    private static double result;
    private static double num1;
    private static double num2;

    private static Logger logger = LogManager.getLogger(Submit.class.getName());

    public static void submit(JTextField textFieldInput1, JTextField textFieldInput2, JTextField textFieldOutput, String operation) {
        if(operation != null){
            switch(operation){
                case "multiplication":
                    num1 = Double.parseDouble(textFieldInput1.getText());
                    num2 = Double.parseDouble(textFieldInput2.getText());

                    result = num1 * num2;
                    textFieldOutput.setText(String.valueOf(result));

                    break;
                case "addition":
                    num1 = Double.parseDouble(textFieldInput1.getText());
                    num2 = Double.parseDouble(textFieldInput2.getText());

                    result = num1 + num2;
                    textFieldOutput.setText(String.valueOf(result));

                    break;
                case "subtraction":
                    num1 = Double.parseDouble(textFieldInput1.getText());
                    num2 = Double.parseDouble(textFieldInput2.getText());

                    result = num1 - num2;
                    textFieldOutput.setText(String.valueOf(result));

                    break;
                case "division":
                    num1 = Double.parseDouble(textFieldInput1.getText());
                    num2 = Double.parseDouble(textFieldInput2.getText());

                    if(num1 == 0 || num2 == 0) {
                        textFieldOutput.setText("Undefined");
                        ErrorHandling.throwWarningGUI(null, "Can't divide by 0.", null);

                        logger.warn("Division by 0 occurred.");
                    }
                    else {

                        result = num1 / num2;
                        textFieldOutput.setText(String.valueOf(result));
                    }

                    break;
                case "squareroot":
                    num1 = Double.parseDouble(textFieldInput1.getText());
                    num2 = Double.parseDouble(textFieldInput2.getText());

                    textFieldOutput.setText("Number 1: " + Math.sqrt(num1) + ", Number 2: " + Math.sqrt(num2));

                    break;
                case "radians":
                    num1 = Double.parseDouble(textFieldInput1.getText());
                    num2 = Double.parseDouble(textFieldInput2.getText());

                    textFieldOutput.setText("Number 1: " + Math.toRadians(num1) + ", Number 2: " + Math.toRadians(num2));

                    break;
                case "degrees":
                    num1 = Double.parseDouble(textFieldInput1.getText());
                    num2 = Double.parseDouble(textFieldInput2.getText());

                    textFieldOutput.setText("Number 1: " + Math.toDegrees(num1) + ", Number 2: " + Math.toDegrees(num2));

                    break;
                case "sine":
                    num1 = Double.parseDouble(textFieldInput1.getText());
                    num2 = Double.parseDouble(textFieldInput2.getText());

                    textFieldOutput.setText("Number 1: " + Math.sin(num1) + ", Number 2: " + Math.sin(num2));

                    break;
                case "cosine":
                    num1 = Double.parseDouble(textFieldInput1.getText());
                    num2 = Double.parseDouble(textFieldInput2.getText());

                    textFieldOutput.setText("Number 1: " + Math.cos(num1) + ", Number 2: " + Math.cos(num2));

                    break;
                case "tangent":
                    num1 = Double.parseDouble(textFieldInput1.getText());
                    num2 = Double.parseDouble(textFieldInput2.getText());

                    textFieldOutput.setText("Number 1: " + Math.tan(num1) + ", Number 2: " + Math.tan(num2));

                    break;
            }
        }
    }
}
