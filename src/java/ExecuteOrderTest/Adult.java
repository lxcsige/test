package ExecuteOrderTest;

/**
 * User: lxcfour
 * Date: 2018/5/8
 * Time: 上午9:59
 */
public class Adult extends Human {

    private static int aField;

    private int id;

    static {
        aField = 1;
        System.out.println("aField = 1");
    }

    {
        id = 321284;
        System.out.println("id = 321284");
    }

    public Adult() {
        this.id = 321285;
        System.out.println("constructor id = 321285");
    }

    public static void main(String[] args) {
        Adult human = new Adult();
        human.print1();
        human.print2();
    }
}
