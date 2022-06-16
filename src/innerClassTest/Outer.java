package innerClassTest;

/**
 * @author xucheng.liu
 * @since 2022/3/11
 */
public class Outer {

    private static int id;

    private String name;

    /**
     * 成员内部类
     */
    class Inner {

        private int innerId;

        private String innerName;

        public void test() {
            // 可以访问外部类的静态/成员变量和方法
            System.out.println("outer.id: " + id);
            System.out.println("outer.name: " + name);
        }
    }

    /**
     * 静态内部类
     */
    static class StaticInner {

        private static int innerId;

        private String innerName;

        public void test() {
            // 只能访问外部类的静态变量和方法
            System.out.println("outer.id: " + id);
            outerTest();
        }
    }

    public static void outerTest() {
        System.out.println("outer static test");
    }

    public void testLocalInner(){
        int localId = 3;
        // 局部内部类
        class Inner {
            private void fun(){
                System.out.println(id);
                System.out.println(name);
                System.out.println(localId);
            } }
        Inner inner = new Inner();
        inner.fun();
    }

    public static void testStaticLocalInner(){
        int localId = 3;
        // 局部内部类
        class Inner {
            private void fun(){
                System.out.println(id);
                // 编译错误，定义在静态方法中的局部类不能访问外部类的实例变量
//                System.out.println(name);
                System.out.println(localId);
            } }
        Inner inner = new Inner();
        inner.fun();
    }

    public void testAnonymousInner(int limit) {
        int times = 2;
        new InterfaceA() {
            @Override
            public void method() {
                for (int i = 0; i < times; i++) {
                    System.out.println("匿名内部类");
                }
            }
        }.method();
    }
}
