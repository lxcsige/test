package design.pattern.proxy.dynamicProxy;

/**
 * @author liuxucheng
 * @since 2022/12/23
 */
public class Subject implements ISubject {

    @Override
    public void echo() {
        System.out.println("echo");
    }

    @Override
    public void print() {
        System.out.println("print");
    }
}
