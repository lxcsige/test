package SingletonTest;

/**
 * User: lxcfour
 * Date: 2018/3/30
 * Time: 上午10:54
 */
public class Singleton2 {
    // volatile是为了禁止指令重排序
    private static volatile Singleton2 instance;

    private Singleton2(){

    }

    // double check，只有第一次调用时才需要进入同步块，可能有多个线程进入同步块，因此需要再次判断instance == null
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    // 这一步操作不是原子的
                    instance = new Singleton2();
                }
            }
        }

        return instance;
    }
}
