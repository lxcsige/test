package defaultMethodTest;

/**
 * @author xucheng.liu
 * @since 2022/3/11
 */
public class Main {

    public static void main(String[] args) {
        ParentB c = new ClassC();
        // 类优先原则
        c.print();

        c.staticMethod();
    }
}
