package base.reflect.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 代理处理器类
 *
 * @author liuxucheng
 * @date 2018/1/18
 */

public class ProxyHandler implements InvocationHandler {

    /**
     * 需要代理的目标对象
     */
    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before processing");
        Object result = method.invoke(target, args);
        System.out.println("after processing");
        return result;
    }

    /**
     * 生成代理类实例
     *
     * @param target
     * @return
     */
    public static Object wrap(Object target) {
        Class<?> type = target.getClass();
        Class<?>[] interfaces = getAllInterfaces(type);
        if (interfaces.length > 0) {
            return Proxy.newProxyInstance(type.getClassLoader(), interfaces, new ProxyHandler(target));
        }
        return target;
    }

    /**
     * 获取所有接口
     *
     * @param type
     * @return
     */
    private static Class<?>[] getAllInterfaces(Class<?> type) {
        Set<Class<?>> interfaces = new HashSet<>();
        while (type != null) {
            interfaces.addAll(Arrays.asList(type.getInterfaces()));
            type = type.getSuperclass();
        }
        return interfaces.toArray(new Class<?>[0]);
    }
}