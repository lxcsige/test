package concurrency.synchronize;

/**
 * @author xucheng.liu
 * @since 2022/3/29
 */
public class TestA {

    private final Object lock = new Object();

    public synchronized void print() throws InterruptedException {
        while(true) {

        }
    }

    public synchronized void write() throws InterruptedException {
        System.out.println("write");
    }

    public synchronized static void staticPrint() {
        System.out.println("staticPrint");
    }

    public void echo() {
        synchronized (lock) {
            System.out.println("echo");
        }
    }
}
