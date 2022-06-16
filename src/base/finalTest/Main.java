package base.finalTest;

/**
 * @author xucheng.liu
 * @since 2022/3/28
 */
public class Main {

    public static void main(String[] args) {
        Parent p = new Child();
        p.print();

        Child c = new Child();
        c.print();
    }
}
