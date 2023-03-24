package design.pattern.bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxucheng
 * @since 2022/12/26
 */
public class Client {

    public static void main(String[] args) {
        Implementor implementor = new ImplementorA();
        Abstraction abstraction = new RefinedAbstractionA(implementor);
        abstraction.operate();

        List<String> addresses = new ArrayList<>();
        addresses.add("lxcshang@163.com");
        EmailSender emailSender = new EmailSender(addresses);
        Notifier notifier = new UrgencyNotifier(emailSender);
        notifier.notify("host [127.0.0.1] has shut down!!!");
    }
}
