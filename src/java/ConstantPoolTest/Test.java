package ConstantPoolTest;

import java.util.ArrayList;
import java.util.List;

/**
 * User: lxcfour
 * Date: 2018/3/24
 * Time: 下午8:23
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * jdk1.7以上不会抛错，因为字符串常量池不在方法区中
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
