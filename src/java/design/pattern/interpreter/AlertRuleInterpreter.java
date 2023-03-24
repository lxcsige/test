package design.pattern.interpreter;

import java.util.Map;

/**
 * @author liuxucheng
 * @since 2023/1/28
 */
public class AlertRuleInterpreter {

    private final Expression expression;

    public AlertRuleInterpreter(String ruleExpression) {
        // ||优先级最低
        this.expression = new OrExpression(ruleExpression);
    }

    public boolean interpret(Map<String, Long> stats) {
        return expression.interpret(stats);
    }
}
