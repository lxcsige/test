package base.exception;

/**
 * @author xucheng.liu
 * @since 2022/3/28
 */
public class TryCatchTest {

    public static void main(String[] args) {
        try {
            System.out.println("try");
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            // 编译器自动将finally语句块的内容冗余到每个可能出现的分支路径后
            System.out.println("finally");
        }
    }
}
