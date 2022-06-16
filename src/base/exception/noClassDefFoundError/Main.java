package base.exception.noClassDefFoundError;

/**
 * 模拟noClassDefFoundError
 *
 * @author xucheng.liu
 * @since 2022/3/27
 */
public class Main {

    public static void main(String[] args) {
        TestA testA = new TestA();
        testA.hello();

        try {
            double divideZero = TestB.divideZero;
        }catch (Throwable e){
            // ExceptionInInitializerError
            e.printStackTrace();
        }

        TestB.print();
    }
}
