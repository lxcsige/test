package SingletonTest;

/**
 * Created by lxcfour on 2016/11/18.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton()  {
        if (instance != null) {
            throw new RuntimeException("fuck you bitch");
        }
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
