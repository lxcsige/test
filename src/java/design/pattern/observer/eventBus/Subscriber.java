package design.pattern.observer.eventBus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * 订阅者
 *
 * @author liuxucheng
 * @since 2023/1/3
 */
public class Subscriber {

    /**
     * 所属的事件总线
     */
    private EventBus eventBus;

    /**
     * 实际的订阅对象
     */
    private Object target;

    /**
     * 订阅方法
     */
    private Method method;

    /**
     * 执行器接口，可能同步执行，也可能异步执行
     */
    private Executor executor;

    public Subscriber(EventBus eventBus, Object target, Method method) {
        this.eventBus = eventBus;
        this.target = target;

        this.method = method;
        // 保证method可以访问
        method.setAccessible(true);

        this.executor = eventBus.getExecutor();
    }

    /**
     * 收到通知后的处理逻辑
     *
     * @param event
     */
    public void execute(Object event) {
        executor.execute(() -> {
            try {
                method.invoke(target, event);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public final int hashCode() {
        return (31 + method.hashCode()) * 31 + System.identityHashCode(target);
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof Subscriber) {
            Subscriber that = (Subscriber) obj;
            return target == that.target && method.equals(that.method);
        }
        return false;
    }
}
