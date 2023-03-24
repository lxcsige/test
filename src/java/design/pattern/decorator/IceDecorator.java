package design.pattern.decorator;

/**
 * 冰块装饰器类
 *
 * @author liuxucheng
 * @since 2022/12/27
 */
public class IceDecorator extends CondimentDecorator {

    public IceDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description() + ", ice";
    }

    @Override
    public double cost() {
        return beverage.cost();
    }
}
