package base.bit;

/**
 * @author liuxucheng
 * @since 2022/6/27
 */
public class Test {

    public static void main(String[] args) {
        int v = 12;
        int m0 = 7;
        System.out.println((v | m0) + 1);
        v = (((v | m0) + 1) & ~m0) | (v & m0);
        System.out.println(v);
    }
}
