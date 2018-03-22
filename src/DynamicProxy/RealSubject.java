package DynamicProxy;

/**
 * Created by liuxucheng on 2018/1/18.
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("processing");
    }
}
