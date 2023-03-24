package design.pattern.bridge;

/**
 * @author liuxucheng
 * @since 2022/12/26
 */
public class ImplementorA implements Implementor {

    @Override
    public void implement() {
        System.out.println("A");
    }
}
