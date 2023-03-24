package design.pattern.singleton;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author liuxucheng
 * @since 2022/12/13
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException,
            IllegalAccessException, MalformedURLException, NoSuchMethodException, InvocationTargetException {
        File file = new File("/Users/liuxucheng/dp/Test/out/production/test/");
        MyClassLoader classLoader = new MyClassLoader(new URL[]{file.toURL()});
        classLoader.printLoadedClass("java.lang.Object");
        classLoader.loadClass("design.pattern.singleton.Singleton1");
        classLoader.printLoadedClass("java.lang.Object");
        classLoader.printLoadedClass("design.pattern.singleton.Singleton1");
        ClassLoader systemClassLoader = Thread.currentThread().getContextClassLoader();
        Method method = systemClassLoader.getClass().getSuperclass().getSuperclass().getSuperclass()
                .getDeclaredMethod("findLoadedClass", String.class);
        method.setAccessible(true);
        System.out.println(method.invoke(systemClassLoader, "design.pattern.singleton.Singleton1"));
        System.out.println(method.invoke(systemClassLoader, "java.lang.Object"));
        System.out.println(method.invoke(systemClassLoader, "java.lang.OutOfMemoryError"));
        ChildOfOomError error = new ChildOfOomError();
        System.out.println(method.invoke(systemClassLoader, "java.lang.OutOfMemoryError"));
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(method.invoke(systemClassLoader, "design.pattern.singleton.Singleton2"));
        System.out.println(method.invoke(systemClassLoader.getParent(), "design.pattern.singleton.Singleton2"));
    }

    public static class ChildOfOomError extends OutOfMemoryError {

    }
}
