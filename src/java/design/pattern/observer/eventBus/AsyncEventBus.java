package design.pattern.observer.eventBus;

import java.util.concurrent.Executor;

/**
 * @author liuxucheng
 * @since 2023/1/3
 */
public class AsyncEventBus extends EventBus {

    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
