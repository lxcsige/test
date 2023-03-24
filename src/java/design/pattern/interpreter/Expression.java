package design.pattern.interpreter;

import java.util.Map;

/**
 * @author liuxucheng
 * @since 2023/1/28
 */
public interface Expression {

    /**
     * 解释
     *
     * @return
     */
    default long interpret() {
        return 0L;
    }

    /**
     * 解释
     *
     * @param stats
     * @return
     */
    default boolean interpret(Map<String, Long> stats) {
        return true;
    }
}
