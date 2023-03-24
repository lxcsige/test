package design.pattern.observer;

/**
 * @author liuxucheng
 * @since 2023/1/3
 */
public class Client {

    public static void main(String[] args) {
        Observable subject = new Subject();
        Observer observerOne = new ConcreteObserverOne();
        // 将观察者注册到被观察者
        subject.registerObserver(observerOne);
        // 通知观察者
        subject.notifyObservers(new Message());
    }
}
