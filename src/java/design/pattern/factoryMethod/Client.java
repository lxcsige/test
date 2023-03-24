package design.pattern.factoryMethod;

/**
 * @author liuxucheng
 * @since 2022/12/22
 */
public class Client {

    public static void main(String[] args) {
        // 具体工厂类负责创建对应的具体产品
        Factory factory = getFactory("productA");
        Product product = factory.createProduct();
        product.method();

        Factory factory1 = FactoryMap.getFactory("productB");
        Product product1 = factory1.createProduct();
        product1.method();
    }

    private static Factory getFactory(String arg) {
        // if-else逻辑从工厂类转移到了客户端
        if ("productA".equals(arg)) {
            return new FactoryA();
        }
        return new FactoryB();
    }
}
