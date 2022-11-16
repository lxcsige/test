package java.jvm;

/**
 * 即时编译测试
 *
 * @author liuxucheng
 * @since 2022/6/20
 */
public class JitTest {

    public static void main(String[] args) {
        foo();
    }

    public static void foo() {
        int sum = 0;
        for (int i = 0; i < 200; i++) {
            sum += i;
        }
    }
}
