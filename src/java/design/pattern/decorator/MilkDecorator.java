package design.pattern.decorator;

/**
 * @author liuxucheng
 * @since 2022/12/27
 */
public class MilkDecorator extends CondimentDecorator {

    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description() + ", milk";
    }

    @Override
    public double cost() {
        return 0.1 + beverage.cost();
    }
}
