package base.reflect;

import java.lang.reflect.Field;

/**
 * @author xucheng.liu
 * @since 2022/3/23
 */
public class StringTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str1 = "Hello world";
        String str2 = "Hello world";
        Field valueField = String.class.getDeclaredField("value");
        valueField.setAccessible(true);
        char[] value = (char[]) valueField.get(str1);
        value[5] = '_';

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
    }
}
