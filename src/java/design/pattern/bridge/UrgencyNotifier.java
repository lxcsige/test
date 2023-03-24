package design.pattern.bridge;

/**
 * @author liuxucheng
 * @since 2022/12/26
 */
public class UrgencyNotifier extends Notifier {

    public UrgencyNotifier(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public boolean notify(String message) {
        message = "Urgent!!!" + message;
        return msgSender.send(message);
    }
}
