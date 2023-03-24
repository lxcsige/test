package design.pattern.bridge;

/**
 * @author liuxucheng
 * @since 2022/12/26
 */
public class SevereNotifier extends Notifier {

    public SevereNotifier(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public boolean notify(String message) {
        message = "Severe!!!" + message;
        return msgSender.send(message);
    }
}
