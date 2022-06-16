package jmm;

/**
 * @author xucheng.liu
 * @since 2022/4/16
 */
public class ThreadDemo implements Runnable {

    volatile boolean flag;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("thread2 flag = " + flag);
    }
}
