package design.pattern.decorator;

/**
 * 深度烘焙咖啡类
 *
 * @author liuxucheng
 * @since 2022/12/26
 */
public class DarkRoast implements Beverage {

    @Override
    public String description() {
        return "darkRoast";
    }

    @Override
    public double cost() {
        return .99;
    }

    @Override
    public int sugar() {
        return 0;
    }
}
