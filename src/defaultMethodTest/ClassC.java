package defaultMethodTest;

/**
 *
 * @author xucheng.liu
 * @since 2022/3/11
 */
public class ClassC extends ParentB implements InterfaceA, InterfaceD {

    /**
     * 如果没有继承ParentB，则会出现接口默认方法冲突，必须重写
     */
    @Override
    public void method() {
        System.out.println("method C");
    }

    public static void staticMethod() {
        System.out.println("static method C");
    }
}
