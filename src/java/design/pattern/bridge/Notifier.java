package design.pattern.bridge;

/**
 * @author liuxucheng
 * @since 2022/12/26
 */
public abstract class Notifier {

    protected MsgSender msgSender;

    public Notifier(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract boolean notify(String message);
}
