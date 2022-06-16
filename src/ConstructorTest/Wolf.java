package ConstructorTest;

/**
 * @author xucheng.liu
 * @date 2020/3/30
 */
public class Wolf extends Animal {

    static {
        System.out.println("Wolf的静态初始化块");
    }

    {
        System.out.println("Wolf的非静态初始化块");
    }

    public Wolf() {
        System.out.println("Wolf的无参构造函数");
    }

    public Wolf(String name) {
        this();
        System.out.println("Wolf的带参构造函数，name参数：" + name);
    }
}
