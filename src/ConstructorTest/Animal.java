package ConstructorTest;

/**
 * @author xucheng.liu
 * @date 2020/3/30
 */
public class Animal extends Creature {

    static {
        System.out.println("Animal的静态初始化块");
    }

    {
        System.out.println("Animal的非静态初始化块");
    }

    public Animal() {
        System.out.println("Animal的无参构造函数");
    }

    public Animal(String name) {
        this();
        System.out.println("Animal的带参构造函数，name参数：" + name);
    }
}
