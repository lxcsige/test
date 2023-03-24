package design.pattern.adapter;

/**
 * 组合+委托
 *
 * @author liuxucheng
 * @since 2022/12/27
 */
public class ObjectAdapter implements ITarget {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {
        System.out.println("f2");
        adaptee.fb();
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}
