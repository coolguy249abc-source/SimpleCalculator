package net.neskul.simplecalculator.frames;

import net.neskul.simplecalculator.Calculations.Eval;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class EvalFrame {
    public static final JFrame frame = new JFrame();

    private static final Logger logger = LogManager.getLogger(EvalFrame.class.getName());

    public static JTextField textAreaExpression = new JTextField();
    public static JTextField textAreaResult = new JTextField();

    public static JButton submitButton = new JButton("Submit");

    public static final JMenuBar menuBar = new JMenuBar();
    public static final JMenu modesMenu = new JMenu("Modes");
    public static final JMenu helpMenu = new JMenu("Help");
    public static final JMenuItem advancedItem = new JMenuItem("Advanced Mode");
    public static final JMenuItem simpleItem = new JMenuItem("Simple Mode");
    public static final JMenuItem evalItem = new JMenuItem("Eval Mode");
    public static final JMenuItem exitItem = new JMenuItem("Exit");
    public static final JMenuItem aboutItem = new JMenuItem("About");
    public static final JMenuItem evalHelpItem = new JMenuItem("Eval Help");

    public static final JLabel titleLabel = new JLabel("Calculator");
    public static final JLabel expressionLabel = new JLabel("Expression: ");
    public static final JLabel resultLabel = new JLabel("Result: ");

    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 525;

    public EvalFrame() {
        // Title label
        titleLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        titleLabel.setBounds((SCREEN_WIDTH / 2) - 35, (SCREEN_HEIGHT / 3) - 125, 150, 25); // x, y, width, height
        frame.add(titleLabel);

        // Expression Label
        expressionLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        expressionLabel.setBounds((SCREEN_WIDTH / 2) - 275, SCREEN_HEIGHT / 3, 150, 25); // x, y, width, height
        frame.add(expressionLabel);

        // Expression Textfield
        textAreaExpression.setBounds((SCREEN_WIDTH / 2) - (340 - 200), SCREEN_HEIGHT / 3, 350, 25); // x, y, width, height
        frame.add(textAreaExpression);

        // Result Label
        resultLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        resultLabel.setBounds((SCREEN_WIDTH / 2) - 275, (SCREEN_HEIGHT / 3) + 75, 150, 25); // x, y, width, height
        frame.add(resultLabel);

        // Result Textfield
        textAreaResult.setBounds((SCREEN_WIDTH / 2) - (340 - 200), (SCREEN_HEIGHT / 3) + 75, 350, 25); // x, y, width, height
        frame.add(textAreaResult);

        // Submit button
        submitButton.setBounds((SCREEN_WIDTH / 2) - 35, (SCREEN_HEIGHT / 3) + 125, 100, 50);
        frame.add(submitButton);

        submitButton.addActionListener(e -> {
            String ex = textAreaExpression.getText();

            Eval eval = new Eval();
            textAreaResult.setText(String.valueOf(eval.evaluateExpression(ex)));
        });

        // Menu bar
        menuBar.add(modesMenu);
        menuBar.add(helpMenu);

        // Advanced mode
        advancedItem.addActionListener(e -> {
            logger.debug("Advanced mode activated");

            frame.revalidate();
            frame.repaint();

            frame.setVisible(false);
            SimpleFrame.frame.setVisible(true);

            SimpleFrame.frame.add(SimpleFrame.sineButton);
            SimpleFrame.frame.add(SimpleFrame.cosineButton);
            SimpleFrame.frame.add(SimpleFrame.tangentButton);
            SimpleFrame.frame.add(SimpleFrame.radiansButton);
            SimpleFrame.frame.add(SimpleFrame.degreesButton);

            SimpleFrame.frame.revalidate();
            SimpleFrame.frame.repaint();
        });

        modesMenu.add(advancedItem);

        // Simple Mode
        simpleItem.addActionListener(e -> {
            logger.debug("Simple mode activated");

            frame.revalidate();
            frame.repaint();

            frame.setVisible(false);
            SimpleFrame.frame.setVisible(true);

            SimpleFrame.frame.remove(SimpleFrame.sineButton);
            SimpleFrame.frame.remove(SimpleFrame.cosineButton);
            SimpleFrame.frame.remove(SimpleFrame.tangentButton);
            SimpleFrame.frame.remove(SimpleFrame.radiansButton);
            SimpleFrame.frame.remove(SimpleFrame.degreesButton);

            SimpleFrame.frame.revalidate();
            SimpleFrame.frame.repaint();
        });

        modesMenu.add(simpleItem);

        // Exit
        exitItem.addActionListener(e -> {
            logger.debug("Exiting program...");
            System.exit(0);
        });

        modesMenu.addSeparator();
        modesMenu.add(exitItem);

        // Eval Help
        evalHelpItem.addActionListener(e -> {
            logger.debug("Eval Help window Opened!");

            JDialog box = new JDialog(frame, "Eval Help");
            JLabel label = new JLabel("<html>The eval funtion is made with EvalEx (made by ezylang on github). <br>" +
                    "SQRT(n) - Square root<br>" +
                    "() - parentheses<br>" +
                    "/ - Division<br>" +
                    "* - Multiplication<br>" +
                    "+ - Addition<br>" +
                    "- - Subtraction<br>" +
                    "% - Modulus<br>" +
                    "n^n - n by the power of n<br>" +
                    "SIN(n), COS(n), TAN(n) - Sine, Cosine, Tangent<br>" +
                    "PI = 3.1415926535897932384626433…<br>" +
                    "E = 2.71828182845904523536028747…<br>" +
                    "NULL = null<br>" +
                    "TRUE = Boolean.true<br>" +
                    "FALSE = Boolean.false</html>");

            JButton closeButton = new JButton("Close");

            label.setFont(new Font("Verdana", Font.PLAIN, 16));
            box.setLayout(new FlowLayout());
            box.add(label);
            box.add(closeButton);

            box.pack();

            // box.setSize(100, 125);
            box.setVisible(true);

            closeButton.addActionListener(l -> {
                box.setVisible(false); // just in case (:
                box.dispose();
            });
        });

        helpMenu.add(evalHelpItem);

        // About
        aboutItem.addActionListener(e -> {
            logger.debug("About window open!");

            JDialog box = new JDialog(frame, "Eval Help");
            JLabel label = new JLabel("<html><marquee>Hi!</marquee><br>" +
                    "I am neskul, and I made this calculator app! <br>" +
                    "The eval function was developed by ezylang on github. <br>" +
                    "This calculator uses Log4J and EvalEx. <br>" +
                    "If you dont know what eval is, its basicly just an app that reads ecuations and expressions to develop an answer.");

            JButton closeButton = new JButton("Close");

            label.setFont(new Font("Verdana", Font.PLAIN, 16));
            box.setLayout(new FlowLayout());
            box.add(label);
            box.add(closeButton);

            /* BufferedImage image;
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/images/ham.png"));
            } catch (IOException ex) {
                logger.fatal("An error occured reading image");
                ErrorHandling.throwExceptionGUI(null, ex, "An error occured reading image", null);
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }

            JLabel picLabel = new JLabel(new ImageIcon(image));

            box.add(picLabel); */
            box.pack();

            // box.setSize(100, 125);
            box.setVisible(true);

            closeButton.addActionListener(l -> {
                box.setVisible(false); // just in case (:
                box.dispose();
            });
        });

        helpMenu.add(aboutItem);

        // Frame
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT); // x, y
        frame.setTitle("Calculator - Eval Mode");
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
