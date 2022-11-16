package base.polymorphism;

/**
 * @author liuxucheng
 * @since 2022/6/20
 */
public class Parent {

    protected int age = 30;

    public void eat() {
        System.out.println("parent eat");
    }

    public void sleep() {
        System.out.println("parent sleep");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
