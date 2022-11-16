package base.boxing;

/**
 * @author liuxucheng
 * @since 2022/6/20
 */
public class Test {

    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3; // 自动装箱，相当于调用Integer.valueOf(3)
        int c = 3;
        System.out.println(a == b); // 比较引用
        System.out.println(b == c); // 自动拆箱，相当于调用intValue，比较值

        int d = b++; // 自动拆箱
    }
}
