package ConstructorTest;

/**
 * @author xucheng.liu
 * @date 2020/3/30
 */
public class Creature {

    static {
        System.out.println("Creature的静态初始化块");
    }

    {
        System.out.println("Creature的非静态初始化块");
    }

    public Creature() {
        System.out.println("Creature的无参构造函数");
    }

    public Creature(String name) {
        this();
        System.out.println("Creature的带参构造函数，name参数：" + name);
    }
}
