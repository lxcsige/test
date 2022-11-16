package GenericTest;

import java.lang.reflect.Field;

/**
 * User: lxcfour
 * Date: 2018/3/14
 * Time: 下午8:21
 */
public class Test2 {

    public static void main(String[] args) {
        Container<String, String> container = new Container<>("1", "2");
        String k = container.getKey();
        Field[] fields = container.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("name: " + field.getName() + ", type: " + field.getType());
        }
    }
}
