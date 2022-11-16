package base.polymorphism;

/**
 * @author liuxucheng
 * @since 2022/6/20
 */
public class Main {

    public static void main(String[] args) {
        Parent parent = new Child();
        // 子类中没有覆写eat方法，因此调用父类的eat()方法
        parent.eat();
        // 子类中覆写了sleep方法，因此调用子类的sleep()方法
        parent.sleep();
        // 访问父类的成员变量
        System.out.println(parent.age);
    }
}
