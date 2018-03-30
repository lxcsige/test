package SingletonTest;

/**
 * User: lxcfour
 * Date: 2018/3/30
 * Time: 上午11:04
 */
public class Singleton3 {

    private Singleton3() {
        System.out.println("test");
    }

    private static class SingletonHolder {
        private static final Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        Singleton3 instance1 = Singleton3.getInstance();
        Singleton3 instance2 = Singleton3.getInstance();
        System.out.println(instance1 == instance2);
    }
}
