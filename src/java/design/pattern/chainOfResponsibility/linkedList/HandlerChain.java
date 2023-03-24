package design.pattern.chainOfResponsibility.linkedList;

/**
 * @author liuxucheng
 * @since 2023/1/9
 */
public class HandlerChain {

    private Handler head;

    private Handler tail;

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);
        if (head == null) {
           head = handler;
           tail = handler;
           return;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null) {
            head.handle();
        }
    }
}
