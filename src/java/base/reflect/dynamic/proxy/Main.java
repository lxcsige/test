package base.reflect.dynamic.proxy;

/**
 * @author liuxucheng
 * @since 2022/6/23
 */
public class Main {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject target = new SubjectImpl();
        ProxyHandler proxyHandler = new ProxyHandler(target);
        Subject proxy = (Subject) proxyHandler.getProxy();
        proxy.method();
    }
}
