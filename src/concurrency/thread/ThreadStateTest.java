package concurrency.thread;

import java.util.Scanner;

/**
 * Java线程状态测试
 *
 * @author xucheng.liu
 * @since 2022/4/6
 */
public class ThreadStateTest {

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            {
                System.out.println(Thread.currentThread().getState());
                Scanner scanner = new Scanner(System.in);
                System.out.println("waiting enter sth: ");
                String s = scanner.next();
                System.out.println(Thread.currentThread().getState());
            }
        };

        Thread t1 = new Thread(task, "t1");
        System.out.println(t1.getState());

        t1.start();

        Thread.sleep(1000);
        // 等待IO，但java线程处于RUNNABLE状态
        System.out.println(t1.getState());
    }
}
