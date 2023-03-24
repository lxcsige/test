package design.pattern.proxy.dynamicProxy;

/**
 * @author liuxucheng
 * @since 2022/6/23
 */
public class Client {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ProxyHandler proxyHandler = new ProxyHandler(new Subject());
        ISubject proxy = (ISubject) proxyHandler.getProxy();
        proxy.echo();
        proxy.print();
    }
}
