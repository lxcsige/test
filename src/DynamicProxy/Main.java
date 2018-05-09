package DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Created by liuxucheng on 2018/1/18.
 */
public class Main {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        ProxyHandler proxyHandler = new ProxyHandler(realSubject);
        // 创建动态代理对象，jvm运行时动态生成的一个对象
        Subject proxy1 = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), proxyHandler);
        String name = proxy1.getClass().getSuperclass().getName();
        int modifier = proxy1.getClass().getModifiers();
        proxy1.request();
    }
}
