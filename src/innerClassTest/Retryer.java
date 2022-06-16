package innerClassTest;

/**
 * @author xucheng.liu
 * @since 2022/3/11
 */
public class Retryer {

    public <T> T execute(RetryCallback<T> retryCallback) {
        System.out.println("before callback");
        T result = retryCallback.doWithRetry();
        System.out.println("after callback");
        return result;
    }
}
