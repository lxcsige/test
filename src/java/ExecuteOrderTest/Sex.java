package ExecuteOrderTest;

/**
 * User: lxcfour
 * Date: 2018/5/8
 * Time: 上午9:56
 */
public class Sex {

    private static int sField;

    static {
       sField = 1;
       System.out.println("sField = " + sField);
    }

    private int value;

    {
        value = 1;
        System.out.println("value = " + value);
    }

    private int value2 = printf();

    public int getValue() {
        return value;
    }

    public Sex() {
        System.out.println("sex constructor");
    }

    public int printf() {
        System.out.println("value2 = 2");
        return 2;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }
}
