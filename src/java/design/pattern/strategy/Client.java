package design.pattern.strategy;

/**
 * @author liuxucheng
 * @since 2023/1/9
 */
public class Client {

    public static void main(String[] args) {
        String type = "+";
        Calculator calculator = null;
        for (Calculator calculatorEnum : Calculator.values()) {
            if (calculatorEnum.getValue().equals(type)) {
                calculator = calculatorEnum;
                break;
            }
        }
        if (calculator == null) {
            throw new IllegalArgumentException("");
        }
        calculator.exec(1, 2);
    }
}
