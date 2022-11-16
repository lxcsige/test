package base.polymorphism;

/**
 * @author liuxucheng
 * @since 2022/6/20
 */
public class Child extends Parent {

    protected int age = 10;

    public void sleep() {
        super.sleep();
        System.out.println("child sleep");
    }

    public void play() {
        System.out.println("child sleep");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
