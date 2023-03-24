package design.pattern.abstractFactory;

/**
 * @author liuxucheng
 * @since 2022/12/22
 */
public class Client {

    public static void main(String[] args) {
        // 客户端应该使用同一产品族的对象
        Factory factory = new MacFactory();
        Screen screen = factory.createScreen();
        KeyBoard keyBoard = factory.createKeyBoard();
    }
}
