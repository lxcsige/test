package ExecutorTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liuxucheng on 2018/5/23.
 */
public class Test {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService = Executors.newCachedThreadPool();
    }
}
