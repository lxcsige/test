package innerClassTest;

/**
 * @author xucheng.liu
 * @since 2022/3/11
 */
public class Main {

    public static void main(String[] args) {
        // 先创建外部类实例，再创建内部类实例
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        // 不依赖外部类实例的创建
        Outer.StaticInner staticInner = new Outer.StaticInner();

        outer.testAnonymousInner(2);

        Retryer retryer = new Retryer();
        retryer.execute(new RetryCallback<String>() {

            @Override
            public String doWithRetry() {
                System.out.println("callback");
                return "callback";
            }
        });
    }
}
