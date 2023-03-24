package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * @author liuxucheng
 * @since 2022/12/19
 */
public class MultiThreadLocalTest {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static <T>CompletableFuture<T> invokeToCompletableFuture(Supplier<T> supplier) {
        // 在主线程中获取上下文
        String context = contextHolder.get();
        Supplier<T> newSupplier = () -> {
            // 获取threadLocal的初始值
            String initial = contextHolder.get();
            try {
                // 将主线程的变量值赋给当前线程
                contextHolder.set(context);
                return supplier.get();
            } finally {
                // 复原，放置内存泄漏
                contextHolder.set(initial);
                System.out.println(Thread.currentThread().getName() + ": " + initial);
            }
        };
        return CompletableFuture.supplyAsync(newSupplier);
    }

    public static void main(String[] args) throws InterruptedException {
        contextHolder.set("main");
        System.out.println(Thread.currentThread().getName() + ": " + contextHolder.get());
        CompletableFuture<String> context = invokeToCompletableFuture(contextHolder::get);
        System.out.println(Thread.currentThread().getName() + ": " + contextHolder.get());
    }
}
