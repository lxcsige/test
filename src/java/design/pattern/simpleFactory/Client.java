package design.pattern.simpleFactory;

/**
 * @author liuxucheng
 * @since 2022/12/22
 */
public class Client {

    public static void main(String[] args) {
        // 客户端使用比较方便，判断逻辑均包含在Factory类中
        Product product = Factory.createProduct("productA");
        product.method();
    }
}
