package base.exception;

/**
 * @author liuxucheng
 * @since 2022/6/21
 */
public class NoClassDefFoundErrorTest {

    public static void main(String[] args) {
        try {
            double divideZero = InitFail.divideZero;
        }catch (Throwable e){
            // 第一次会抛ExceptionInInitializerError
            System.out.println(e);
        }
        //继续使用
        InitFail.print();
    }
}
