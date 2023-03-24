package design.pattern.observer.eventBus;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author liuxucheng
 * @since 2023/1/3
 */
public class EventBus {

    private final Executor executor;

    private final SubscriberRegistry registry = new SubscriberRegistry(this);

    public EventBus() {
        this.executor = DirectExecutor.getInstance();
    }

    EventBus(Executor executor) {
        this.executor = executor;
    }

    /**
     * 订阅
     *
     * @param subscriber
     */
    public void register(Object subscriber) {
        registry.register(subscriber);
    }

    /**
     * 取消订阅
     *
     * @param subscriber
     */
    public void unregister(Object subscriber) {
        registry.register(subscriber);
    }

    /**
     * 通知
     *
     * @param event
     */
    public void post(Object event) {
        List<Subscriber> subscribers = registry.getSubscribers(event);
        if (subscribers == null) {
            return;
        }
        for (Subscriber subscriber : subscribers) {
            subscriber.execute(event);
        }
    }

    public Executor getExecutor() {
        return executor;
    }
}
