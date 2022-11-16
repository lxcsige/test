package base.reflect.dynamic.proxy;

/**
 * @author liuxucheng
 * @since 2022/6/23
 */
public class SubjectImpl implements Subject {

    @Override
    public void method() {
        System.out.println("method");
    }
}
