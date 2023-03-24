package design.pattern.observer;

/**
 * 观察者
 *
 * @author liuxucheng
 * @since 2023/1/3
 */
public interface Observer {

    /**
     * 接收到通知后的处理逻辑
     *
     * @param message
     */
    void update(Message message);
}
