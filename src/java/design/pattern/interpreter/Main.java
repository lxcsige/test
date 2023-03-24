package design.pattern.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxucheng
 * @since 2023/1/28
 */
public class Main {

    public static void main(String[] args) {
        AlertRuleInterpreter alertRuleInterpreter = new AlertRuleInterpreter("a > 1 && b < 2 && c == 4 || d == 10");
        Map<String, Long> stats = new HashMap<>();
        stats.put("a", 1L);
        stats.put("b", 2L);
        stats.put("c", 3L);
        stats.put("d", 10L);
        System.out.println(alertRuleInterpreter.interpret(stats));
    }
}
