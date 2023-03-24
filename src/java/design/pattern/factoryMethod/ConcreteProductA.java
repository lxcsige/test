package design.pattern.factoryMethod;

/**
 * @author liuxucheng
 * @since 2022/12/22
 */
public class ConcreteProductA implements Product {

    @Override
    public void method() {
        System.out.println("productA");
    }
}
