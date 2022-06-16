package base;

/**
 * 装箱和拆箱
 *
 * @author xucheng.liu
 * @since 2022/3/23
 */
public class BoxTest {

    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
    }
}
