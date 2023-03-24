package oop.abstractAndInterface;

/**
 * @author liuxucheng
 * @since 2022/11/28
 */
public interface Inter {

    /**
     * public
     */
    void show();

    /**
     * 默认方法，新增之后不需要修改所有实现类
     */
    default void method() {
        System.out.println("默认方法1");
    }

    default void method2() {
        System.out.println("默认方法2");
    }

    /**
     * 类静态方法，只能通过接口名调用，不能通过实现类名或对象名调用（多实现）
     * Inter.test();
     */
    static void test() {
        System.out.println("静态方法");
    }
}
