package base.classLoader;

import sun.misc.Launcher;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author liuxucheng
 * @since 2022/6/21
 */
public class Test {

    public static void main(String[] args) throws MalformedURLException {
        // BootstrapClassLoader加载路径
        String pathStr = System.getProperty("sun.boot.class.path");
        String[] pathArr = pathStr.split(":");
        for (String path : pathArr) {
            System.out.println(path);
        }
        System.out.println("------------------------------------------");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }

        // ExtClassLoader加载路径
        String extPathStr = System.getProperty("java.ext.dirs");
        String[] extPathArr = extPathStr.split(":");
        for (String path : extPathArr) {
            System.out.println(path);
        }
        System.out.println("------------------------------------------");

        // SystemClassLoader加载路径
        System.out.println(System.getProperty("java.class.path"));

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File("/Users/liuxucheng");
        URL url1 = file.toURL();
        URL url2 = new URL("jar:file:/Users/liuxucheng/.m2/repository/org/springframework/spring-context/5.3.6/spring-context-5.3.6.jar!/");
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url1, url2});
        Class<?> clazz;
        try {
            clazz = urlClassLoader.loadClass("org.springframework.context.NoSuchMessageException");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
