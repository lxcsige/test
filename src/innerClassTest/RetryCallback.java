package innerClassTest;

/**
 * @author xucheng.liu
 * @since 2022/3/11
 */
public interface RetryCallback<T> {

    T doWithRetry();
}
