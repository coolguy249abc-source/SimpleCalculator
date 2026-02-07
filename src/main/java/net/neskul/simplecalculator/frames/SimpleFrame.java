package net.neskul.simplecalculator.frames;

import net.neskul.simplecalculator.SimpleCalculator;
import net.neskul.simplecalculator.Submit;
import net.neskul.simplecalculator.error.ErrorHandling;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class SimpleFrame {
    private static Logger logger = LogManager.getLogger(SimpleFrame.class.getName());

    public static final JFrame frame = new JFrame();

    public static JTextField textAreaNum1 = new JTextField();
    public static JTextField textAreaNum2 = new JTextField();
    public static JTextField textAreaResultSimple = new JTextField();

    public static JButton divisonButton = new JButton("/");
    public static JButton subtractionButton = new JButton("-");
    public static JButton additionButton = new JButton("+");
    public static JButton multiplicationButton = new JButton("*");
    public static JButton modulusButton = new JButton("%");
    public static JButton squareRootButton = new JButton("√");
    public static JButton radiansButton = new JButton("rad");
    public static JButton degreesButton = new JButton("deg");
    public static JButton sineButton = new JButton("sin");
    public static JButton cosineButton = new JButton("cos");
    public static JButton tangentButton = new JButton("tan");
    public static JButton submitButton = new JButton("Submit");

    public static final JLabel titleLabel = new JLabel("Calculator");
    public static final JLabel num1Label = new JLabel("First number: ");
    public static final JLabel num2Label = new JLabel("Second number: ");
    public static final JLabel resultLabel = new JLabel("Result: ");

    public static final JMenuBar menuBar = new JMenuBar();
    public static final JMenu modesMenu = new JMenu("Modes");
    public static final JMenuItem advancedItem = new JMenuItem("Advanced Mode");
    public static final JMenuItem simpleItem = new JMenuItem("Simple Mode");
    public static final JMenuItem evalItem = new JMenuItem("Eval Mode");
    public static final JMenuItem exitItem = new JMenuItem("Exit");


    public static String operation;

    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 525;

    public SimpleFrame() {
        try {
            // Title label
            titleLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
            titleLabel.setBounds((SCREEN_WIDTH / 2) - 35, (SCREEN_HEIGHT / 3) - 125, 150, 25); // x, y, width, height
            frame.add(titleLabel);

            // Num 1 Label
            num1Label.setFont(new Font("Verdana", Font.PLAIN, 15));
            num1Label.setBounds((SCREEN_WIDTH / 2) - 275, (SCREEN_HEIGHT / 3) - 50, 150, 25); // x, y, width, height
            frame.add(num1Label);

            // Num 1 TextArea
            textAreaNum1.setFont(new Font("Verdana", Font.PLAIN, 14));
            textAreaNum1.setBounds((SCREEN_WIDTH / 2) - 150, SCREEN_HEIGHT / 3, 350, 25); // x, y, width, height
            frame.add(textAreaNum1);

            // Num 2 Label
            num2Label.setFont(new Font("Verdana", Font.PLAIN, 15));
            num2Label.setBounds((SCREEN_WIDTH / 2) - 275, (SCREEN_HEIGHT / 3) - 0, 150, 25); // x, y, width, height
            frame.add(num2Label);

            // Num 2 TextArea
            textAreaNum2.setFont(new Font("Verdana", Font.PLAIN, 14));
            textAreaNum2.setBounds((SCREEN_WIDTH / 2) - 150, (SCREEN_HEIGHT / 3) - 50, 350, 25); // x, y, width, height
            frame.add(textAreaNum2);

            // Result Label
            resultLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
            resultLabel.setBounds((SCREEN_WIDTH / 2) - 275, (SCREEN_HEIGHT / 3) + 125, 150, 25); // x, y, width, height
            frame.add(resultLabel);

            // Result TextArea
            textAreaResultSimple.setFont(new Font("Verdana", Font.PLAIN, 14));
            textAreaResultSimple.setBounds((SCREEN_WIDTH / 2) - 150, (SCREEN_HEIGHT / 3) + 125, 350, 25); // x, y, width, height
            frame.add(textAreaResultSimple);

            // Multiplication
            multiplicationButton.setBounds((SCREEN_WIDTH / 2) - 220, (SCREEN_HEIGHT / 3) + 170, 50, 50); // x, y, width, height
            frame.add(multiplicationButton);

            multiplicationButton.addActionListener(e -> {
                operation = "multiplication";
            });

            // Division
            divisonButton.setBounds((SCREEN_WIDTH / 2) + (60 - 220), (SCREEN_HEIGHT / 3) + 170, 50, 50); // x, y, width, height
            frame.add(divisonButton);

            divisonButton.addActionListener(e -> {
                operation = "division";
            });

            // Addition
            additionButton.setBounds((SCREEN_WIDTH / 2) + (120 - 220), (SCREEN_HEIGHT / 3) + 170, 50, 50); // x, y, width, height
            frame.add(additionButton);

            additionButton.addActionListener(e -> {
                operation = "addition";
            });

            // Subtraction
            subtractionButton.setBounds((SCREEN_WIDTH / 2) + (180 - 220), (SCREEN_HEIGHT / 3) + 170, 50, 50); // x, y, width, height
            frame.add(subtractionButton);

            subtractionButton.addActionListener(e -> {
                operation = "subtraction";
            });

            // Modulus
            modulusButton.setBounds((SCREEN_WIDTH / 2) + (240 - 220), (SCREEN_HEIGHT / 3) + 170, 50, 50); // x, y, width, height
            frame.add(modulusButton);

            modulusButton.addActionListener(e -> {
                operation = "modulus";
            });

            // Square Root
            squareRootButton.setBounds((SCREEN_WIDTH / 2) + (300 - 220), (SCREEN_HEIGHT / 3) + 170, 50, 50); // x, y, width, height
            frame.add(squareRootButton);

            squareRootButton.addActionListener(e -> {
                operation = "squareroot";
            });

            // To Radians
            radiansButton.setBounds((SCREEN_WIDTH / 2) - 220, (SCREEN_HEIGHT / 3) + (170 + 60), 75, 50); // x, y, width, height

            radiansButton.addActionListener(e -> {
                operation = "radians";
            });

            // To Degrees
            degreesButton.setBounds((SCREEN_WIDTH / 2) - (220 - 85), (SCREEN_HEIGHT / 3) + (170 + 60), 75, 50); // x, y, width, height

            degreesButton.addActionListener(e -> {
                operation = "degrees";
            });

            // Tangent
            tangentButton.setBounds((SCREEN_WIDTH / 2) - (220 - 170), (SCREEN_HEIGHT / 3) + (170 + 60), 75, 50); // x, y, width, height

            tangentButton.addActionListener(e -> {
                operation = "tangent";
            });

            // Sine
            sineButton.setBounds((SCREEN_WIDTH / 2) - (220 - 255), (SCREEN_HEIGHT / 3) + (170 + 60), 75, 50); // x, y, width, height;

            sineButton.addActionListener(e -> {
                operation = "sine";
            });

            // Cosine
            cosineButton.setBounds((SCREEN_WIDTH / 2) - (220 - 340), (SCREEN_HEIGHT / 3) + (170 + 60), 75, 50); // x, y, width, height

            cosineButton.addActionListener(e -> {
                operation = "cosine";
            });

            // Submit
            submitButton.setBounds((SCREEN_WIDTH / 2) + 145, (SCREEN_HEIGHT / 3) + 170, 100, 50); // x, y, width, height
            frame.add(submitButton);

            submitButton.addActionListener(e -> {
               Submit.submit(textAreaNum1, textAreaNum2, textAreaResultSimple, operation);
            });

            // Menu bar
            menuBar.add(modesMenu);

            // Advanced mode
            advancedItem.addActionListener(e -> {
                logger.debug("Advanced mode activated");

                frame.revalidate();
                frame.repaint();

                frame.add(sineButton);
                frame.add(cosineButton);
                frame.add(tangentButton);
                frame.add(radiansButton);
                frame.add(degreesButton);
            });

            modesMenu.add(advancedItem);

            // Simple Mode
            simpleItem.addActionListener(e -> {
                logger.debug("Simple mode activated");

                frame.revalidate();
                frame.repaint();

                frame.remove(sineButton);
                frame.remove(cosineButton);
                frame.remove(tangentButton);
                frame.remove(radiansButton);
                frame.remove(degreesButton);
            });

            modesMenu.add(simpleItem);

            // Eval mode
            evalItem.addActionListener(e -> {
                frame.setVisible(false);
                new EvalFrame();
            });

            modesMenu.add(evalItem);

            // Exit
            exitItem.addActionListener(e -> {
                logger.debug("Exiting program...");
                System.exit(0);
            });

            modesMenu.addSeparator();
            modesMenu.add(exitItem);

            // Frame
            frame.setJMenuBar(menuBar);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT); // x, y
            frame.setTitle("Calculator");
            frame.setLayout(null);
            frame.setVisible(true);
        } catch (Exception e) {
            ErrorHandling.throwExceptionGUI(null, e, "An error occured: " + e, null);
        }
    }
}
