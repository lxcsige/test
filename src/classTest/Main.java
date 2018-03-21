package classTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lxcfour on 2017/7/11.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //读取本地的class文件内的字节码，转换成字节码数组
        File file = new File(".");
        InputStream input = new FileInputStream(file.getCanonicalPath() + "/out/production/test/classTest/Test.class");
        byte[] result = new byte[1024];

        int count = input.read(result);
        // 使用自定义的类加载器将 byte字节码数组转换为对应的class对象
        MyClassLoader loader = new MyClassLoader();
        Class clazz = loader.defineMyClass(result, 0, count);
        //测试加载是否成功，打印class 对象的名称
        System.out.println(clazz.getCanonicalName());

        try {
            Object o = clazz.newInstance();
            clazz.getMethod("printTest", null).invoke(o, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
