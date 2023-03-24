package concurrency.lock.countDownLatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxucheng
 * @since 2023/3/5
 */
public class CountDownLatchTest2 {

    private static final List<Integer> list = new ArrayList<>();

    public void add(int i) {
        list.add(i);
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {
        CountDownLatchTest2 t2 = new CountDownLatchTest2();
        Object lock = new Object();
        new Thread(() -> {
            synchronized(lock){
                System.out.println("t2 启动");
                if(list.size() != 5){
                    try {
                        // 等待t1唤醒
                        lock.wait();
                        System.out.println("t2 结束");
                    } catch (InterruptedException e) {

                    }
                }
                // 唤醒t1
                lock.notify();
            }
        }).start();

        new Thread(() -> {
            synchronized (lock){
                System.out.println("t1 启动");
                for (int i = 0; i < 9; i++){
                    list.add(i);
                    System.out.println("add " + i);
                    if(list.size() == 5){
                        // 唤醒t1
                        lock.notify();
                        // 等待t2唤醒
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {

                        }
                    }
                }
            }
        }).start();
    }
}
