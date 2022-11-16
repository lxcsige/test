package ThreadStatusTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuxucheng on 2018/5/18.
 */
public class WaitingTest {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        new Thread(new Blocked(), "BlockedThread1").start();
        new Thread(new Blocked(), "BlockedThread2").start();
    }

    static class TimeWaiting implements Runnable {
        public void run() {
            while(true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Waiting implements Runnable {
        @Override
        public void run() {
            while(true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                        System.out.print("awake");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {
        @Override
        public void run() {
            while(true) {
                synchronized (Blocked.class) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
