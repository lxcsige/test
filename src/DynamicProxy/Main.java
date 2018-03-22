package DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Created by liuxucheng on 2018/1/18.
 */
public class Main {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        ProxyHandler proxyHandler = new ProxyHandler(realSubject);
        Subject proxy1 = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), proxyHandler);
        Subject proxy2 = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), proxyHandler);
        proxy1.request();
    }
}
