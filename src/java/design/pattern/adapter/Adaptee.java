package design.pattern.adapter;

/**
 * 需要适配的类
 *
 * @author liuxucheng
 * @since 2022/12/27
 */
public class Adaptee {

    public void fa() {
        System.out.println("fa");
    }

    public void fb() {
        System.out.println("fb");
    }

    public void fc() {
        System.out.println("fc");
    }
}
