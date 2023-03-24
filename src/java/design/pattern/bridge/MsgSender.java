package design.pattern.bridge;

/**
 * @author liuxucheng
 * @since 2022/12/26
 */
public interface MsgSender {

    /**
     * 发送信息
     *
     * @param message
     * @return
     */
    boolean send(String message);
}
