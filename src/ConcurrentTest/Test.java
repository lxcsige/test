package ConcurrentTest;

import java.util.concurrent.TimeUnit;

/**
 * User: lxcfour
 * Date: 2018/2/26
 * Time: 下午7:55
 */
public class Test {

    static Object lock = new Object();

    public static void main(String[] args) {
        Thread wait = new Thread(new Wait(), "wait");
        Thread notify = new Thread(new Notify(), "notify");
        wait.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify.start();
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("wait hold lock");
                while(true) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("wait end");
                }
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("notify hold lock");
                lock.notify();
                System.out.println("notify end");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
