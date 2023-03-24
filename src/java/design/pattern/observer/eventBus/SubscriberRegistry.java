package design.pattern.observer.eventBus;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 订阅者注册类
 *
 * @author liuxucheng
 * @since 2023/1/3
 */
public class SubscriberRegistry {

    /**
     * 事件类型和其订阅者的映射
     */
    private final Map<Class<?>, CopyOnWriteArraySet<Subscriber>> subscribers = new ConcurrentHashMap<>();

    private final EventBus bus;

    public SubscriberRegistry(EventBus bus) {
        this.bus = bus;
    }

    /**
     * 注册订阅者
     *
     * @param subscriber
     */
    public void register(Object subscriber) {
        Map<Class<?>, List<Subscriber>> subscriberMethods = parseSubscriber(subscriber);
        for (Map.Entry<Class<?>, List<Subscriber>> entry : subscriberMethods.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<Subscriber> eventMethodsInSubscriber = entry.getValue();

            CopyOnWriteArraySet<Subscriber> eventSubscribers = subscribers.get(eventType);
            if (eventSubscribers == null) {
                // 注意这里的顺序
                // 可能存在多线程同时调用putIfAbsent方法，最终只有一个线程成功
                subscribers.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
                eventSubscribers = subscribers.get(eventType);
            }
            eventSubscribers.addAll(eventMethodsInSubscriber);
        }
    }

    /**
     * 取消订阅
     *
     * @param subscriber
     */
    public void unregister(Object subscriber) {
        Map<Class<?>, List<Subscriber>> subscriberMethods = parseSubscriber(subscriber);
        for (Map.Entry<Class<?>, List<Subscriber>> entry : subscriberMethods.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<Subscriber> eventMethodsInSubscriber = entry.getValue();

            CopyOnWriteArraySet<Subscriber> eventSubscribers = subscribers.get(eventType);
            if (eventSubscribers == null) {
                continue;
            }
            eventMethodsInSubscriber.forEach(eventSubscribers::remove);
        }
    }

    /**
     * 根据事件找到相应的订阅者实例
     *
     * @param event
     * @return
     */
    List<Subscriber> getSubscribers(Object event) {
        List<Subscriber> result = new ArrayList<>();

        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<Subscriber>> entry : subscribers.entrySet()) {
            Class<?> eventType = entry.getKey();
            CopyOnWriteArraySet<Subscriber> eventActions = entry.getValue();

            // 同时也会将父类事件的订阅者添加到结果中
            if (eventType.isAssignableFrom(postedEventType)) {
                result.addAll(eventActions);
            }
        }

        return result;
    }

    /**
     * 根据参数subscriber对象中被注解的方法，找到相应的subscriber集合
     * 注意，subscriber中可能存在多个相同/不同事件类型的处理方法，因此返回结果是一个MAP类型
     *
     * @param subscriber
     * @return
     */
    private Map<Class<?>, List<Subscriber>> parseSubscriber(Object subscriber) {
        Map<Class<?>, List<Subscriber>> result = new HashMap<>();

        Class<?> clazz = subscriber.getClass();
        for (Method method : getAnnotatedMethods(clazz)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            // @Subscribe注解的方法只能有一个参数，参数类型表示事件类型
            Class<?> eventType = parameterTypes[0];
            if (result.containsKey(eventType)) {
                result.put(eventType, new ArrayList<>());
            }
            result.get(eventType).add(new Subscriber(bus, subscriber, method));
        }

        return result;
    }

    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();

        // TODO 将@Subscribe注解的方法集合缓存在本地
        // TODO 遍历所有父类，寻找@Subscribe注解的方法
        for (Method method : clazz.getDeclaredMethods()) {
            // 找到存在@Subscribe注解的方法
            if (method.isAnnotationPresent(Subscribe.class)) {
                // 校验参数个数，仅保留只有一个参数的方法
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    continue;
                }
                annotatedMethods.add(method);
            }
        }

        return annotatedMethods;
    }
}
