package ReentrantLockTest;

/**
 * User: lxcfour
 * Date: 2018/5/15
 * Time: 下午9:11
 */
public class Test1 {

    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        // 模拟任务代码
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // ... 清理操作
                        // 重设中断标志位
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(isInterrupted());
            }
        };
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        thread.interrupt();
    }
}
