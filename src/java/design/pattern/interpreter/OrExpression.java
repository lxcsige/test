package design.pattern.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ||运算符，优先级最低
 *
 * @author liuxucheng
 * @since 2023/1/28
 */
public class OrExpression implements Expression {

    private List<Expression> expressions = new ArrayList<>();

    public OrExpression(String strOrExpression) {
        // 按||分割字符串
        String[] andExpressions = strOrExpression.split("\\|\\|");
        for (String andExpr : andExpressions) {
            expressions.add(new AndExpression(andExpr));
        }
    }

    public OrExpression(List<Expression> expressions) {
        this.expressions.addAll(expressions);
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        for (Expression expression : expressions) {
            if (expression.interpret(stats)) {
                return true;
            }
        }
        return false;
    }
}
