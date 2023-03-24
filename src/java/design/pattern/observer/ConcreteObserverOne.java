package design.pattern.observer;

/**
 * 具体的观察者
 *
 * @author liuxucheng
 * @since 2023/1/3
 */
public class ConcreteObserverOne implements Observer {

    @Override
    public void update(Message message) {
        System.out.println("concreteObserverOne update");
    }
}
