package design.pattern.factoryMethod;

/**
 * @author liuxucheng
 * @since 2022/12/22
 */
public class FactoryA implements Factory {

    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}
