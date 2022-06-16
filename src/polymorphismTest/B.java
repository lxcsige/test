package polymorphismTest;

/**
 * @author xucheng.liu
 * @since 2022/3/10
 */
public class B extends A {

    public String show(B obj){
        return ("B and B");
    }

    public String show(A obj){
        return ("B and A");
    }

    @Override
    protected void print() {
        super.print();
        System.out.println("B");
    }

    public static void test1() {
        System.out.println("static B");
    }
}
