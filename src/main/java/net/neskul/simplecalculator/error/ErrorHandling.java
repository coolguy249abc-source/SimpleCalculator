package net.neskul.simplecalculator.error;

import javax.swing.*;

public class ErrorHandling {
    public static void throwExceptionGUI(JPanel parent, Exception e, String message, Icon icon) {
        JOptionPane.showMessageDialog(parent, message, "Error", JOptionPane.ERROR_MESSAGE,
                icon);

        e.printStackTrace();
    }

    public static void throwWarningGUI(JPanel parent, String message, Icon icon) {
        JOptionPane.showMessageDialog(parent, message, "Warning", JOptionPane.WARNING_MESSAGE,
                icon);
    }
}
