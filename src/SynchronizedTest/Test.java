package SynchronizedTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuxucheng on 2018/3/10.
 */
public class Test {

    private static boolean flag = true;

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread wait = new Thread(new Wait(), "wait-thread");
        wait.start();
        TimeUnit.SECONDS.sleep(2);
        Thread notify = new Thread(new Notify(), "notify-thread");
        notify.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true");
                        lock.wait();
                    } catch (InterruptedException e) {

                    }
                }
                System.out.println(Thread.currentThread() + " flag is false");
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                flag = false;
                lock.notifyAll();
                try {
                    TimeUnit.SECONDS.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
