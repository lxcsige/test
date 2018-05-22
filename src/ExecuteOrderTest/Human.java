package ExecuteOrderTest;

/**
 * User: lxcfour
 * Date: 2018/5/8
 * Time: 上午9:55
 */
public class Human {

    private static int hField = 3;

    static {
        hField = 4;
        System.out.println("hField = 4");
    }

    private String name;

    {
        name = "human";
        System.out.println("name = human");
    }

    protected int age;

    private Sex sex = new Sex();

    public Human() {
        System.out.println("constructor human");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    private void print() {
        return;
    }

    public final void print1() {
        return;
    }

    public static void print2() {
        return;
    }
}
