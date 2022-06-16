package base.finalTest;

/**
 * final类型转换
 *
 * @author xucheng.liu
 * @since 2022/4/21
 */
public class FinalCast {

    public static void main(String[] args) {
        // 不加final修饰，编译报错
        // 原因是加法运算时会进行类型转换
        final byte a = 1;
        final byte b = 2;
        byte c = a + b;
    }
}
