package design.pattern.decorator;

/**
 * 摩卡装饰器类
 *
 * @author liuxucheng
 * @since 2022/12/26
 */
public class MochaDecorator extends CondimentDecorator {

    public MochaDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description() + ", mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
