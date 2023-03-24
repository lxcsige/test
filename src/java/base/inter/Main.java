package base.inter;

/**
 * @author liuxucheng
 * @since 2022/12/9
 */
public class Main implements InterA, InterB {

    @Override
    public void method() {
        InterA.super.method();
    }
}
