package design.pattern.observer;

/**
 * 被观察者
 *
 * @author liuxucheng
 * @since 2023/1/3
 */
public interface Observable {

    /**
     * 注册观察者
     *
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     *
     * @param observer
     */
    void unregisterObserver(Observer observer);

    /**
     * 通知所有观察者
     *
     * @param message
     */
    void notifyObservers(Message message);
}
