package design.pattern.adapter;

import design.pattern.adapter.Adaptee;
import design.pattern.adapter.ITarget;

/**
 * 适配器类，继承Adaptee并实现ITarget接口
 *
 * @author liuxucheng
 * @since 2022/12/27
 */
public class ClassAdapter extends Adaptee implements ITarget {

    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        System.out.println("f2");
        super.fb();
    }

    // fc()方法可以直接复用
}
