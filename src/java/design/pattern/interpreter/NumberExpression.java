package design.pattern.interpreter;

/**
 * @author liuxucheng
 * @since 2023/1/28
 */
public class NumberExpression implements Expression {

    private long number;

    public NumberExpression(long number) {
        this.number = number;
    }

    public NumberExpression(String number) {
        this.number = Long.parseLong(number);
    }

    @Override
    public long interpret() {
        return 0;
    }
}
