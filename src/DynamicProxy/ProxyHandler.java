package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by liuxucheng on 2018/1/18.
 */

public class ProxyHandler implements InvocationHandler {
    /**
     * 需要被代理的接口
     */
    private Subject subject;

    public ProxyHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before processing");
        Object result = method.invoke(subject, args);
        System.out.println("after processing");
        return result;
    }
}
