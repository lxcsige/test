package SingletonTest;

import SubListTest.Person;

import java.lang.reflect.Constructor;

/**
 * User: lxcfour
 * Date: 2018/5/17
 * Time: 下午3:18
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1);
        try {
            Class clazz = test.getClass().getClassLoader().loadClass("SingletonTest.Singleton");
            Constructor constructor =  clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Singleton singleton2 = (Singleton) constructor.newInstance();
            System.out.println(singleton2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
