package design.pattern.decorator;

/**
 * 浅度烘焙咖啡类
 *
 * @author liuxucheng
 * @since 2022/12/26
 */
public class LightRoast implements Beverage {

    @Override
    public String description() {
        return "lightRoast";
    }

    @Override
    public double cost() {
        return 1.99;
    }

    @Override
    public int sugar() {
        return 0;
    }
}
