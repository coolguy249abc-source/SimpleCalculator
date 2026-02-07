package net.neskul.simplecalculator.Calculations;

import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;
import net.neskul.simplecalculator.error.ErrorHandling;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Eval {
    public static Expression expression;
    public static EvaluationValue result;

    public static Logger logger = LogManager.getLogger(Eval.class.getName());

    public double evaluateExpression(String expression) {
        try {
            this.expression = new Expression(expression);

            result = this.expression.evaluate();
        } catch (Exception e) {
            logger.fatal("An error occured evaluating expression.");
            ErrorHandling.throwExceptionGUI(null, e, "An error occured evaluating expression.", null);
            e.printStackTrace();
        }

        return result.getNumberValue().doubleValue();
    }
}
