package design.pattern.observer.eventBus;

import java.util.concurrent.Executor;

/**
 * 同步执行器，单例模式
 *
 * @author liuxucheng
 * @since 2023/1/3
 */
public enum DirectExecutor implements Executor {
    /**
     * 单例
     */
    INSTANCE;

    @Override
    public void execute(Runnable command) {
        command.run();
    }

    /**
     * 获取同步执行器
     *
     * @return
     */
    public static Executor getInstance() {
        return INSTANCE;
    }
}
