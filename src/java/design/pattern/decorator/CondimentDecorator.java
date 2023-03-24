package design.pattern.decorator;

/**
 * 调味品装饰器基类
 *
 * @author liuxucheng
 * @since 2022/12/26
 */
public abstract class CondimentDecorator implements Beverage {

    protected Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int sugar() {
        return beverage.sugar();
    }
}
