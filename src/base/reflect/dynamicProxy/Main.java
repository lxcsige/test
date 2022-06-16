package base.reflect.dynamicProxy;

/**
 * 调用者
 *
 * @author liuxucheng
 * @date 2018/1/18
 */
public class Main {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        SubjectImpl subjectImpl = new SubjectImpl();
        // 创建动态代理对象，jvm运行时动态生成的一个对象
        Subject proxy = (Subject) ProxyHandler.wrap(subjectImpl);
        proxy.request();
    }
}