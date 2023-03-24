package design.pattern.strategy;

/**
 * 用枚举实现策略模式，适合策略逻辑简单的场景
 *
 * @author liuxucheng
 * @since 2023/1/9
 */
public enum Calculator {
    /**
     * 加法
     */
    ADD("+") {
        @Override
        public int exec(int a, int b) {
            return a + b;
        }
    },

    /**
     * 减法
     */
    SUB("-") {
        @Override
        public int exec(int a, int b) {
            return a - b;
        }
    },
    ;

    private String value;

    Calculator(String value) {
        this.value = value;
    }

    public abstract int exec(int a, int b);

    public String getValue() {
        return value;
    }
}
