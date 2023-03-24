package design.pattern.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * &&运算符，优先级次低
 *
 * @author liuxucheng
 * @since 2023/1/28
 */
public class AndExpression implements Expression {

    private final List<Expression> expressions = new ArrayList<>();

    public AndExpression(String strAndExpression) {
        // 按&&分割字符串
        String[] strExpressions = strAndExpression.split("&&");
        for (String strExpr : strExpressions) {
            if (strExpr.contains(">")) {
                expressions.add(new GreaterExpression(strExpr));
            } else if (strExpr.contains("<")) {
                expressions.add(new LessExpression(strExpr));
            } else if (strExpr.contains("==")) {
                expressions.add(new EqualExpression(strExpr));
            } else {
                throw new RuntimeException("Expression is invalid: " + strAndExpression);
            }
        }
    }

    public AndExpression(List<Expression> expressions) {
        this.expressions.addAll(expressions);
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        for (Expression expression : expressions) {
            if (!expression.interpret(stats)) {
                return false;
            }
        }
        return true;
    }
}
