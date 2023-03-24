package base.inter;

/**
 * @author liuxucheng
 * @since 2022/12/9
 */
public interface InterA {

    default void method() {
        System.out.println("InterA");
    }
}
