package design.pattern.bridge;

import java.util.List;

/**
 * @author liuxucheng
 * @since 2022/12/26
 */
public class EmailSender implements MsgSender {

    private List<String> emailAddresses;

    public EmailSender(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    @Override
    public boolean send(String message) {
        System.out.println(message);
        return true;
    }
}
