package classTest;

/**
 * Created by lxcfour on 2017/7/11.
 */
public class MyClassLoader extends ClassLoader {

    public Class<?> defineMyClass(byte[] bytes, int offset, int len) {
        return super.defineClass(null, bytes, offset, len);
    }
}