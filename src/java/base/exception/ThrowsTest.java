package base.exception;

/**
 * throws可以抛检查式异常以及运行时异常
 *
 * @author liuxucheng
 * @since 2022/12/8
 */
public class ThrowsTest {

    public void method1() throws CustomException {
    }

    public void method2() throws CustomRuntimeException {
        throw new CustomRuntimeException("customRuntime", null, true);
    }

    public void method3() throws CustomRuntimeException {
        throw new CustomRuntimeException("customRuntime", null, false);
    }
}
