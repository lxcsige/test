package design.pattern.adapter;

/**
 * @author liuxucheng
 * @since 2022/12/27
 */
public class Client {

    public static void main(String[] args) {
        // 类适配器
        ITarget target = new ClassAdapter();
        target.f1();
        target.f2();
        target.fc();

        // 对象适配器
        ITarget target2 = new ObjectAdapter(new Adaptee());
        target2.f1();
        target2.f2();
        target2.fc();
    }
}
