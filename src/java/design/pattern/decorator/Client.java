package design.pattern.decorator;

/**
 * @author liuxucheng
 * @since 2022/12/27
 */
public class Client {

    public static void main(String[] args) {
        Beverage coffee = new DarkRoast();
        MilkDecorator milkDecorator = new MilkDecorator(coffee);
        IceDecorator iceDecorator = new IceDecorator(milkDecorator);
        System.out.println(iceDecorator.description());
        System.out.println(iceDecorator.sugar());
        System.out.println(iceDecorator.cost());
    }
}
