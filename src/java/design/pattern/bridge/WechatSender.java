package design.pattern.bridge;

import java.util.List;

/**
 * @author liuxucheng
 * @since 2022/12/26
 */
public class WechatSender implements MsgSender {

    List<String> openIds;

    public WechatSender(List<String> openIds) {
        this.openIds = openIds;
    }

    @Override
    public boolean send(String message) {
        return true;
    }
}
