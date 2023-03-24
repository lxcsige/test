package oop.abstractAndInterface;

/**
 * @author liuxucheng
 * @since 2022/11/28
 */
public class InterImpl implements Inter2 {

    @Override
    public void show() {

    }

    @Override
    public void method() {
        // 注意这里的语法
        Inter2.super.method();
    }

    @Override
    public void method2() {

    }
}
