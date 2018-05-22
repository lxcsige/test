import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liuxucheng on 2018/5/21.
 */
public class ExecutorTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
    }
}
