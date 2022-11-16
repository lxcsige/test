package base.exception;

/**
 * @author liuxucheng
 * @since 2022/6/21
 */
public class InitFail {

    static double divideZero = 1/0;//故意使得类初始化失败.

    public static void print(){
        System.out.println("123");
    }
}
