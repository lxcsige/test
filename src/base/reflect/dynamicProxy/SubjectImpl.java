package base.reflect.dynamicProxy;

/**
 * 需要代理的实现类
 *
 * @author xucheng.liu
 */
public class SubjectImpl implements Subject {

    @Override
    public void request() {
        System.out.println("processing");
    }
}
