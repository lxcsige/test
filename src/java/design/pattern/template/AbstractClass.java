package design.pattern.template;

/**
 * @author liuxucheng
 * @since 2023/1/6
 */
public abstract class AbstractClass {

    /**
     * 模板方法
     */
    public final void templateMethod() {
        method1();
        method2();
    }

    public abstract void method1();

    public abstract  void method2();
}
