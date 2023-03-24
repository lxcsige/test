package design.pattern.interpreter;

import java.util.Map;

/**
 * @author liuxucheng
 * @since 2023/1/28
 */
public class GreaterExpression implements Expression {

    private final String key;

    private final long value;

    public GreaterExpression(String strExpression) {
        // 根据空白符号分割
        String[] elements = strExpression.trim().split("\\s+");
        if (elements.length != 3 || !elements[1].trim().equals(">")) {
            throw new RuntimeException("Expression is invalid: " + strExpression);
        }
        this.key = elements[0].trim();
        this.value = Long.parseLong(elements[2].trim());
    }

    public GreaterExpression(String key, long value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        if (!stats.containsKey(key)) {
            return false;
        }
        long statValue = stats.get(key);
        return statValue > value;
    }
}
