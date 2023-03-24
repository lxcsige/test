package design.pattern.proxy.staticProxy;

/**
 * @author liuxucheng
 * @since 2022/12/23
 */
public class Client {

    public static void main(String[] args) {
        UserControllerProxy1 proxy1 = new UserControllerProxy1(new UserController());
        proxy1.login("1", "1");

        UserControllerProxy2 proxy2 = new UserControllerProxy2();
        proxy2.login("2", "2");
    }
}
