package base.reflect;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author xucheng.liu
 * @date 2021/3/15
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        System.out.println("Bootstrap ClassLoader 加载路径：");

        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("-------------------------------------------------------------------------------");

        URLClassLoader extClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader().getParent();
        System.out.println(extClassLoader);
        System.out.println("ExtClassLoader 加载路径：");
        urls = extClassLoader.getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println("-------------------------------------------------------------------------------");

        URLClassLoader systemClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        System.out.println("SystemClassLoader 加载路径：");
        urls = systemClassLoader.getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }
        System.out.println(System.getProperty("java.class.path"));

        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println("Main classLoader: " + classLoader);

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getContextClassLoader());
        }).start();
    }
}
