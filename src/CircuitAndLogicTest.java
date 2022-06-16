/**
 * 逻辑与/或，短路与/或
 *
 * @author xucheng.liu
 * @since 2022/3/10
 */
public class CircuitAndLogicTest {

    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;

        System.out.println(a && b && test());
        System.out.println("--------------");
        System.out.println(a & b & test());
    }

    private static boolean test() {
        System.out.println("executed");
        return true;
    }
}
