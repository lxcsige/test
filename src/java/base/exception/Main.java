package base.exception;

/**
 * @author liuxucheng
 * @since 2022/12/8
 */
public class Main {

    public static void main(String[] args) throws CustomException {
        ThrowsTest test = new ThrowsTest();
        // 编译器只强制要求处理检查式异常
        test.method1();
        // 即使method2 throws运行时异常，编译器也不会强制要求处理
        test.method2();
    }
}
