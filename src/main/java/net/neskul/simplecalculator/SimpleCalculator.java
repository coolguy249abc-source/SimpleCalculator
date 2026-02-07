package net.neskul.simplecalculator;

import net.neskul.simplecalculator.error.ErrorHandling;
import net.neskul.simplecalculator.frames.SimpleFrame;

import javax.swing.*;
import java.awt.*;

import org.apache.logging.log4j.*;

public class SimpleCalculator {
    private static Logger logger = LogManager.getLogger(SimpleCalculator.class.getName());

    public static void main(String[] args) {
        try {
            logger.debug("Loaded program");
            SimpleFrame simpleFrame = new SimpleFrame();
            logger.debug("SimpleFrame initialized");
        } catch (Exception e) {
            logger.fatal("A fatal error occured!");
            ErrorHandling.throwExceptionGUI(null, e, "An error occured: " + e, null);
        }
    }
}
