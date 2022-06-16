package concurrency.synchronize;

/**
 * @author xucheng.liu
 * @since 2022/3/29
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        TestA testA = new TestA();
        Thread t1 = new Thread(() -> {
            try {
                testA.print();
            } catch (InterruptedException e) {
                System.out.println("t1 interrupt");
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                testA.write();
            } catch (InterruptedException e) {
                System.out.println("t2 interrupt");
            }
        });
        t2.start();

        t2.interrupt();
    }
}
