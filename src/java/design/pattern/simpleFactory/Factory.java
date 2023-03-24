package design.pattern.simpleFactory;

/**
 * 工厂类，负责生产所有产品
 *
 * @author liuxucheng
 * @since 2022/12/22
 */
public class Factory {

    /**
     * 可扩展性差，违背开闭原则
     *
     * @param arg
     * @return
     */
    public static Product createProduct(String arg) {
        if ("productA".equals(arg)) {
            return new ConcreteProductA();
        }
        return new ConcreteProductB();
    }
}
